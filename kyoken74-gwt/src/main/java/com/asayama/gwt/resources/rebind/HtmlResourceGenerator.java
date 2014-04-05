package com.asayama.gwt.resources.rebind;

import java.net.URL;

import com.asayama.gwt.resources.client.HtmlResourcePrototype;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.resources.ext.AbstractResourceGenerator;
import com.google.gwt.resources.ext.ResourceContext;
import com.google.gwt.resources.ext.ResourceGeneratorUtil;
import com.google.gwt.resources.ext.SupportsGeneratorResultCaching;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.StringSourceWriter;

public class HtmlResourceGenerator extends AbstractResourceGenerator implements SupportsGeneratorResultCaching {

    @Override
    public String createAssignment(TreeLogger logger, ResourceContext context, JMethod method) throws UnableToCompleteException {

        URL[] resources = ResourceGeneratorUtil.findResources(logger, context, method);
        int count = resources == null ? 0 : resources.length;
        if (count != 1) {
            logger.log(TreeLogger.ERROR, count + " resources found, 1 was expected", null);
            throw new UnableToCompleteException();
        }

        URL resource = resources[0];
        String url = context.deploy(resource, "text/html", true);

        SourceWriter writer = new StringSourceWriter();
        if (!AbstractResourceGenerator.STRIP_COMMENTS) {
            writer.println("// " + resource.toExternalForm());
        }
        writer.println("new " + HtmlResourcePrototype.class.getName() + "(");
        writer.indent();
        writer.println('"' + method.getName() + "\",");
        writer.println(UriUtils.class.getName() + ".fromTrustedString(" + url + ")");
        writer.outdent();
        writer.print(")");
        return writer.toString();
    }
}
