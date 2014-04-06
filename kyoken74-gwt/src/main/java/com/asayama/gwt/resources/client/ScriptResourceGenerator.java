package com.asayama.gwt.resources.client;

import java.net.URL;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.dev.util.Util;
import com.google.gwt.resources.ext.AbstractResourceGenerator;
import com.google.gwt.resources.ext.ResourceContext;
import com.google.gwt.resources.ext.ResourceGeneratorUtil;
import com.google.gwt.resources.ext.SupportsGeneratorResultCaching;
import com.google.gwt.user.rebind.SourceWriter;
import com.google.gwt.user.rebind.StringSourceWriter;

public class ScriptResourceGenerator extends AbstractResourceGenerator implements SupportsGeneratorResultCaching {

    private static final int MAX_STRING_CHUNK = 16383;

    @Override
    public String createAssignment(TreeLogger logger, ResourceContext context, JMethod method) throws UnableToCompleteException {

        URL[] resources = ResourceGeneratorUtil.findResources(logger, context, method);

        if (resources.length != 1) {
            logger.log(TreeLogger.ERROR, "Exactly one resource must be specified", null);
            throw new UnableToCompleteException();
        }

        URL resource = resources[0];
        SourceWriter writer = new StringSourceWriter();
        writer.println("new " + ScriptResourcePrototype.class.getName() + "() {");
        {
            writer.indent();
            if (!AbstractResourceGenerator.STRIP_COMMENTS) {
                writer.println("// " + resource.toExternalForm());
            }
            writer.println("public String getText() {");
            {
                writer.indent();
                String toWrite = Util.readURLAsString(resource);
                if (toWrite.length() > MAX_STRING_CHUNK) {
                    writeLongString(writer, toWrite);
                } else {
                    writer.println("return \"" + Generator.escape(toWrite) + "\";");
                }
                writer.outdent();
            }
            writer.println("}");
            writer.println("public String getName() {");
            {
                writer.indent();
                writer.println("return \"" + method.getName() + "\";");
                writer.outdent();
            }
            writer.println("}");
            writer.outdent();
        }
        writer.println("}");
        return writer.toString();
    }

    private void writeLongString(SourceWriter writer, String toWrite) {
        writer.println("StringBuilder builder = new StringBuilder();");
        int offset = 0;
        int length = toWrite.length();
        while (offset < length - 1) {
            int subLength = Math.min(MAX_STRING_CHUNK, length - offset);
            writer.print("builder.append(\"");
            writer.print(Generator.escape(toWrite.substring(offset, offset + subLength)));
            writer.println("\");");
            offset += subLength;
        }
        writer.println("return builder.toString();");
    }
}
