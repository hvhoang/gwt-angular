package com.asayama.gwt.resources.client;

import com.google.gwt.resources.client.ResourcePrototype;
import com.google.gwt.resources.ext.DefaultExtensions;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.safehtml.shared.SafeUri;

/**
 * This type is not correctly registered as "interface" in ReferenceMapper.
 * It appears that the previous steps in the compiler assigns the wrong binding
 * characteristics by the time the state is stored in ReferenceMapper. When
 * the compiler looks up HtmlResourcePrototype, which includes HtmlResources
 * as a super interface, it finds HtmlResources as a super interface, but it
 * is stored as a class, causing ClassCastException, much like the one below
 * <pre>
 * Compile with -strict or with -logLevel set to DEBUG or WARN to see all errors.
 *       [ERROR] An internal compiler exception occurred
 * com.google.gwt.dev.jjs.InternalCompilerException: Error constructing Java AST
 * Caused by: java.lang.ClassCastException: com.google.gwt.dev.jjs.ast.JClassType cannot be cast to com.google.gwt.dev.jjs.ast.JInterfaceType
 *  at com.google.gwt.dev.jjs.impl.ReferenceMapper.get(ReferenceMapper.java:158)
 *  at com.google.gwt.dev.jjs.impl.ReferenceMapper.createConstructor(ReferenceMapper.java:201)
 *  at com.google.gwt.dev.jjs.impl.ReferenceMapper.get(ReferenceMapper.java:109)
 *  at com.google.gwt.dev.jjs.impl.GwtAstBuilder$AstVisitor.pushNewExpression(GwtAstBuilder.java:2567)
 *  at com.google.gwt.dev.jjs.impl.GwtAstBuilder$AstVisitor.endVisit(GwtAstBuilder.java:350)
 *  ... 68 more
 *          [ERROR] at TutorialResources_default_InlineClientBundleGenerator.java(10): new com.asayama.gwt.resources.client.HtmlResourcePrototype("gwtModuleXML", com.google.gwt.safehtml.shared.UriUtils.fromTrustedString((GWT.getModuleBaseForStaticFiles() + "840CD91574CADFA17F69821527C21FDF.cache.html")))
 *             org.eclipse.jdt.internal.compiler.ast.AllocationExpression
 * </pre>
 * 
 * @author kyoken74
 */
@DefaultExtensions(value = {".html", ".htm", ".xhtml"})
@ResourceGeneratorType(HtmlResourceGenerator.class)
public interface HtmlResource extends ResourcePrototype {
    public String getName();
    SafeUri getSafeUri();
}
