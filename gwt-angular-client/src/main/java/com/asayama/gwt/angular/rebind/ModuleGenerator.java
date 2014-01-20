package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.rebind.util.JClassTypeUtils;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class ModuleGenerator extends Generator {
	
	static final String CLASS = ModuleGenerator.class.getName();
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
			
			// Identify the controllers to inject
			List<JField> controller = new ArrayList<JField>();
			JField[] fields = classType.getFields();
			for (JField item : fields) {
				JClassType itemClassType = item.getType().isClassOrInterface();
				if (itemClassType != null && JClassTypeUtils.supports(itemClassType, Controller.class)) {
					controller.add(item);
				}
			}
			generator.put("controllerFields",	controller);
			
			// Generate type
			PrintWriter pwriter = context.tryCreate(logger, packageName, generatedSimpleName);
			if (pwriter != null) {
				final String filename = "com/asayama/gwt/angular/rebind/Module.vm";
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
