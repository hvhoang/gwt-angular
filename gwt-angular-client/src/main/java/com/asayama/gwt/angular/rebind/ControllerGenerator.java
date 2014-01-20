package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.rebind.util.JClassTypeUtils;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class ControllerGenerator extends Generator {
	
	static final String CLASS = ControllerGenerator.class.getName();
	static final Logger LOG = Logger.getLogger(CLASS);

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String qualifiedName) throws UnableToCompleteException {
		try {
			TypeOracle typeOracle = context.getTypeOracle();
			JClassType classType = typeOracle.getType(qualifiedName);
			if (classType.isFinal()) {
				throw new UnsupportedOperationException(qualifiedName + " should not be declared final");
			}
			
			VelocityGenerator generator = new VelocityGenerator();
			generator.put("logger", logger);
			generator.put("context", context);
			generator.put("classType", classType);
			
			// Define basic characteristics of the generated type.
			final String suffix = "Generated";
			String packageName = classType.getPackage().getName();
			String simpleName = classType.getSimpleSourceName();
			String generatedQualifiedName = qualifiedName + suffix;
			String generatedSimpleName = simpleName + suffix;
			generator.put("packageName", packageName);
			generator.put("qualifiedName", qualifiedName);
			generator.put("simpleName", simpleName);
			generator.put("generatedQualifiedName", generatedQualifiedName);
			generator.put("generatedSimpleName", generatedSimpleName);
			
			// Identify the methods to export to $scope
			JMethod[] inheritableMethods = classType.getInheritableMethods();
			List<JMethod> exportMethods = new ArrayList<JMethod>();
			for (JMethod item : inheritableMethods) {
				if (item.isPublic()) {
					exportMethods.add(item);
				}
			}
			generator.put("exportMethods", exportMethods);
			
			// Identify the services to inject
			JField[] fields = classType.getFields();
			List<JField> serviceFields = new ArrayList<JField>();
			for (JField item : fields) {
				JClassType itemClassType = item.getType().isClassOrInterface();
				if (itemClassType != null && JClassTypeUtils.supports(itemClassType, Service.class)) {
					serviceFields.add(item);
				}
			}
			generator.put("serviceFields",	serviceFields);
			
			// Generate type
			PrintWriter pwriter = context.tryCreate(logger, packageName, generatedSimpleName);
			if (pwriter != null) {
				final String filename = "com/asayama/gwt/angular/rebind/Controller.vm";
				if (LOG.isLoggable(Level.FINE)) {
					StringWriter swriter = new StringWriter();
					generator.generate(swriter, filename);
					String code = swriter.toString();
					pwriter.write(code);
					LOG.fine(code);
				} else {
					generator.generate(pwriter, filename);
				}
				context.commit(logger, pwriter);
			}
			return generatedQualifiedName;

		} catch (Exception e) {
			e.printStackTrace();
			return qualifiedName;
		}
	}
}
