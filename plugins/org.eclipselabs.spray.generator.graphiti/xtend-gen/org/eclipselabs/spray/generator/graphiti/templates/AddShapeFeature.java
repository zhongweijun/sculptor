package org.eclipselabs.spray.generator.graphiti.templates;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.ImportUtil;
import org.eclipselabs.spray.generator.graphiti.util.LayoutExtensions;
import org.eclipselabs.spray.generator.graphiti.util.MetaModel;
import org.eclipselabs.spray.generator.graphiti.util.XtendProperties;
import org.eclipselabs.spray.mm.spray.Container;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.Layout;
import org.eclipselabs.spray.mm.spray.Line;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.MetaReference;
import org.eclipselabs.spray.mm.spray.SprayElement;
import org.eclipselabs.spray.mm.spray.Text;
import org.eclipselabs.spray.mm.spray.extensions.SprayExtensions;

@SuppressWarnings("all")
public class AddShapeFeature extends FileGenerator {
  
  @Inject
  private ImportUtil importUtil;
  
  @Inject
  private SprayExtensions e1;
  
  @Inject
  private LayoutExtensions e2;
  
  @Inject
  private IQualifiedNameProvider e3;
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((Container) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((Container) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final Container container, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _extensionHeader = this.extensionHeader(this);
    _builder.append(_extensionHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends ");
    _builder.append(className, "");
    _builder.append("Base {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation mainFile(final Container container, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    String _feature_package = GeneratorUtil.feature_package();
    this.importUtil.initImports(_feature_package);
    _builder.newLineIfNotEmpty();
    StringConcatenation _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package_1 = GeneratorUtil.feature_package();
    _builder.append(_feature_package_1, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    StringConcatenation _mainFileBody = this.mainFileBody(container, className);
    final StringConcatenation body = _mainFileBody;
    _builder.newLineIfNotEmpty();
    String _printImports = this.importUtil.printImports();
    _builder.append(_printImports, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(body, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation mainFileBody(final Container container, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    MetaClass _represents = container.getRepresents();
    Diagram _diagram = _represents.getDiagram();
    String _name = _diagram.getName();
    String diagramName = _name;
    _builder.newLineIfNotEmpty();
    MetaClass _represents_1 = container.getRepresents();
    EClass _type = _represents_1.getType();
    EPackage _ePackage = _type.getEPackage();
    String _name_1 = _ePackage.getName();
    String pack = _name_1;
    _builder.newLineIfNotEmpty();
    MetaClass _represents_2 = container.getRepresents();
    EClass _type_1 = _represents_2.getType();
    String _fullPackageName = MetaModel.fullPackageName(_type_1);
    String fullPackage = _fullPackageName;
    _builder.newLineIfNotEmpty();
    String _constainerClass = GeneratorUtil.constainerClass(container);
    String containerType = _constainerClass;
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    _builder.append(fullPackage, "");
    _builder.append(".");
    MetaClass _represents_3 = container.getRepresents();
    String _name_2 = this.e1.getName(_represents_3);
    _builder.append(_name_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IAddContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Text;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Polyline;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.styles.Orientation;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.ContainerShape;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Diagram;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Shape;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.Graphiti;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IGaService;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IPeCreateService;");
    _builder.newLine();
    _builder.append("import ");
    String _util_package = GeneratorUtil.util_package();
    _builder.append(_util_package, "");
    _builder.append(".ISprayColorConstants;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _util_package_1 = GeneratorUtil.util_package();
    _builder.append(_util_package_1, "");
    _builder.append(".ISprayContainer;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _util_package_2 = GeneratorUtil.util_package();
    _builder.append(_util_package_2, "");
    _builder.append(".");
    _builder.append(containerType, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _util_package_3 = GeneratorUtil.util_package();
    _builder.append(_util_package_3, "");
    _builder.append(".SprayContainerService;");
    _builder.newLineIfNotEmpty();
    {
      SprayElement[] _parts = container.getParts();
      Iterable<MetaReference> _filter = IterableExtensions.<MetaReference>filter(((Iterable<? extends Object>)Conversions.doWrapArray(_parts)), org.eclipselabs.spray.mm.spray.MetaReference.class);
      for(final MetaReference metaRef : _filter) {
        _builder.append("    ");
        String _name_3 = this.e1.getName(metaRef);
        XtendProperties.setValue("metaRefName", _name_3);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        MetaClass _represents_4 = container.getRepresents();
        EClass _type_2 = _represents_4.getType();
        EList<EReference> _eAllReferences = _type_2.getEAllReferences();
        final Function1<EReference,Boolean> _function = new Function1<EReference,Boolean>() {
            public Boolean apply(final EReference e) {
              String _name_4 = e.getName();
              String _value = XtendProperties.getValue("metaRefName");
              boolean _operator_equals = ObjectExtensions.operator_equals(_name_4, _value);
              return ((Boolean)_operator_equals);
            }
          };
        EReference _findFirst = IterableExtensions.<EReference>findFirst(_eAllReferences, _function);
        EReference eReference = _findFirst;
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("import ");
        EClass _eReferenceType = eReference.getEReferenceType();
        String _fullPackageName_1 = MetaModel.fullPackageName(_eReferenceType);
        _builder.append(_fullPackageName_1, "");
        _builder.append(".");
        EClass _eReferenceType_1 = eReference.getEReferenceType();
        String _name_5 = _eReferenceType_1.getName();
        _builder.append(_name_5, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractAddShapeFeature {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected final static String typeOrAliasName = \"");
    MetaClass _represents_5 = container.getRepresents();
    String _visibleName = GeneratorUtil.visibleName(_represents_5);
    _builder.append(_visibleName, "    ");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected Diagram targetDiagram = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected ");
    _builder.append(containerType, "    ");
    _builder.append(" container = null;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected IGaService gaService = null;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(className, "	");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container = new ");
    _builder.append(containerType, "		");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("gaService = Graphiti.getGaService();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean canAdd(IAddContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final Object newObject = context.getNewObject();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (newObject instanceof ");
    MetaClass _represents_6 = container.getRepresents();
    String _name_6 = this.e1.getName(_represents_6);
    _builder.append(_name_6, "		");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("// check if user wants to add to a diagram");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (context.getTargetContainer() instanceof Diagram) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PictogramElement add(IAddContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    MetaClass _represents_7 = container.getRepresents();
    String _name_7 = this.e1.getName(_represents_7);
    _builder.append(_name_7, "		");
    _builder.append(" addedModelElement = (");
    MetaClass _represents_8 = container.getRepresents();
    String _name_8 = this.e1.getName(_represents_8);
    _builder.append(_name_8, "		");
    _builder.append(") context.getNewObject();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("targetDiagram = Graphiti.getPeService().getDiagramForShape(context.getTargetContainer());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("IPeCreateService peCreateService = Graphiti.getPeCreateService();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ContainerShape containerShape = container.createContainer(context, addedModelElement);");
    _builder.newLine();
    {
      boolean _hasFillColor = this.e2.hasFillColor(container);
      if (_hasFillColor) {
        _builder.append("GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();");
        _builder.newLine();
        _builder.append("containerGa.setBackground(manageColor(");
        String _fillColor = this.e2.fillColor(container);
        _builder.append(_fillColor, "");
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("        ");
    _builder.append("ContainerShape textContainer = SprayContainerService.findTextShape(containerShape);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("link(containerShape, addedModelElement);");
    _builder.newLine();
    _builder.newLine();
    {
      SprayElement[] _parts_1 = container.getParts();
      for(final SprayElement part : _parts_1) {
        {
          if ((part instanceof org.eclipselabs.spray.mm.spray.Line)) {
            _builder.append("\t\t\t    ");
            Line line = ((Line) part);
            _builder.newLineIfNotEmpty();
            _builder.append("// Part is Line");
            _builder.newLine();
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("// create shape for line");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Shape shape = peCreateService.createShape(textContainer, false);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("// create and set graphics algorithm");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Polyline polyline = gaService.createPolyline(shape, new int[] { 0, 0, 0, 0 });");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("polyline.setForeground(manageColor(");
            String _lineColor = this.e2.lineColor(line);
            _builder.append(_lineColor, "	");
            _builder.append(" ));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("polyline.setLineWidth(");
            Layout _layout = line.getLayout();
            int _lineWidth = _layout.getLineWidth();
            _builder.append(_lineWidth, "	");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            {
              Layout _layout_1 = line.getLayout();
              int _lineWidth_1 = _layout_1.getLineWidth();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_lineWidth_1), ((Integer)0));
              if (_operator_equals_1) {
                _builder.append("polyline.setLineVisible(false);");
                _builder.newLine();
              }
            }
            _builder.append("\t\t            ");
            _builder.append("gaService.setLocation(polyline, 0, 0);");
            _builder.newLine();
            _builder.append("\t\t            ");
            _builder.append("Graphiti.getPeService().setPropertyValue(shape, ISprayContainer.CONCEPT_SHAPE_KEY, ISprayContainer.LINE);");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();} else {
            if ((part instanceof org.eclipselabs.spray.mm.spray.Text)) {
              _builder.append("\t\t\t    ");
              Text text = ((Text) part);
              _builder.newLineIfNotEmpty();
              _builder.append("// Part is Text");
              _builder.newLine();
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("String type = \"");
              QualifiedName _fullyQualifiedName = this.e3.getFullyQualifiedName(text);
              _builder.append(_fullyQualifiedName, "	");
              _builder.append("\";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("// create shape for text and set text graphics algorithm");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("Shape shape = peCreateService.createShape(textContainer, false);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("Text text = gaService.createDefaultText(getDiagram(), shape);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("text.setForeground(manageColor(");
              String _lineColor_1 = this.e2.lineColor(text);
              _builder.append(_lineColor_1, "	");
              _builder.append("));");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);");
              _builder.newLine();
              {
                Layout _layout_2 = text.getLayout();
                boolean _isBold = _layout_2.isBold();
                if (_isBold) {
                  _builder.append("\t\t        ");
                  _builder.append("text.getFont().setBold(true);");
                  _builder.newLine();
                }
              }
              {
                Layout _layout_3 = text.getLayout();
                boolean _isItalic = _layout_3.isItalic();
                if (_isItalic) {
                  _builder.append("\t\t        ");
                  _builder.append("text.getFont().setItalic(true);");
                  _builder.newLine();
                }
              }
              _builder.append("\t");
              _builder.append("gaService.setLocationAndSize(text, 0, 0, 0, 0);");
              _builder.newLine();
              _builder.append("\t\t\t        ");
              _builder.append("Graphiti.getPeService().setPropertyValue(shape, \"MODEL_TYPE\", type);");
              _builder.newLine();
              _builder.append("\t\t            ");
              _builder.append("Graphiti.getPeService().setPropertyValue(shape, ISprayContainer.CONCEPT_SHAPE_KEY, ISprayContainer.TEXT);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("// create link and wire it");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("link(shape, addedModelElement);");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();} else {
              if ((part instanceof org.eclipselabs.spray.mm.spray.MetaReference)) {
                _builder.append("\t\t\t    ");
                MetaReference metaRef_1 = ((MetaReference) part);
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t    ");
                String _name_9 = this.e1.getName(metaRef_1);
                XtendProperties.setValue("metaRefName", _name_9);
                _builder.newLineIfNotEmpty();
                MetaClass _represents_9 = container.getRepresents();
                EClass _type_3 = _represents_9.getType();
                EList<EReference> _eAllReferences_1 = _type_3.getEAllReferences();
                final Function1<EReference,Boolean> _function_1 = new Function1<EReference,Boolean>() {
                    public Boolean apply(final EReference e_1) {
                      String _name_10 = e_1.getName();
                      String _value_1 = XtendProperties.getValue("metaRefName");
                      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_name_10, _value_1);
                      return ((Boolean)_operator_equals_2);
                    }
                  };
                EReference _findFirst_1 = IterableExtensions.<EReference>findFirst(_eAllReferences_1, _function_1);
                EReference eReference_1 = _findFirst_1;
                _builder.append(" ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t    \t");
                _builder.append("// Part is reference list");
                _builder.newLine();
                _builder.append("{");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("// Create a dummy invisible line to have an ancjhor point for adding new elements to the list");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("Shape dummy = peCreateService.createShape(textContainer, false);");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("Graphiti.getPeService().setPropertyValue(dummy, \"MODEL_TYPE\", \"");
                EClass _eReferenceType_2 = eReference_1.getEReferenceType();
                String _name_11 = _eReferenceType_2.getName();
                _builder.append(_name_11, "			        ");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("Polyline p = gaService.createPolyline(dummy, new int[] { 0, 0, 0, 0 });");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("p.setForeground(manageColor(");
                String _shortName = this.importUtil.shortName(org.eclipse.graphiti.util.IColorConstant.class);
                _builder.append(_shortName, "	");
                _builder.append(".BLACK));");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("p.setLineWidth(0);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("p.setLineVisible(false);");
                _builder.newLine();
                _builder.append("\t\t            ");
                _builder.append("gaService.setLocation(p, 0, 0);");
                _builder.newLine();
                _builder.append("\t\t            ");
                _builder.append("Graphiti.getPeService().setPropertyValue(dummy, ISprayContainer.CONCEPT_SHAPE_KEY, ISprayContainer.LINE);");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();
                _builder.append("for (");
                EClass _eReferenceType_3 = eReference_1.getEReferenceType();
                String _name_12 = _eReferenceType_3.getName();
                _builder.append(_name_12, "");
                _builder.append(" p : addedModelElement.get");
                String _name_13 = this.e1.getName(metaRef_1);
                String _firstUpper = StringExtensions.toFirstUpper(_name_13);
                _builder.append(_firstUpper, "");
                _builder.append("()) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("Shape shape = peCreateService.createContainerShape(textContainer, true);");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("Graphiti.getPeService().setPropertyValue(shape, \"STATIC\", \"true\");");
                _builder.newLine();
                _builder.append("\t\t\t        ");
                _builder.append("Graphiti.getPeService().setPropertyValue(shape, \"MODEL_TYPE\", \"");
                EClass _eReferenceType_4 = eReference_1.getEReferenceType();
                String _name_14 = _eReferenceType_4.getName();
                _builder.append(_name_14, "			        ");
                _builder.append("\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t            ");
                _builder.append("Graphiti.getPeService().setPropertyValue(shape, ISprayContainer.CONCEPT_SHAPE_KEY, ISprayContainer.TEXT);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("// create and set text graphics algorithm");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("Text text = gaService.createDefaultText(getDiagram(), shape, p.get");
                String _labelPropertyName = this.e1.getLabelPropertyName(metaRef_1);
                String _firstUpper_1 = StringExtensions.toFirstUpper(_labelPropertyName);
                _builder.append(_firstUpper_1, "	");
                _builder.append("());");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("// TODO should have a text color here, refer to representation of reference type");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("text.setForeground(manageColor(");
                String _textColor = this.e2.textColor(container);
                _builder.append(_textColor, "	");
                _builder.append(")); ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("text.setVerticalAlignment(Orientation.ALIGNMENT_TOP);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("gaService.setLocationAndSize(text, 0, 0, 0, 0);");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("// create link and wire it");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("link(shape, p);");
                _builder.newLine();
                _builder.append("}");
                _builder.newLine();} else {
                _builder.append("// TODO");
                _builder.newLine();
                _builder.append("System.out.println(\"Spray: unhandled Container child [");
                Class<? extends Object> _class = part.getClass();
                String _name_15 = _class.getName();
                _builder.append(_name_15, "");
                _builder.append("]\");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// add a chopbox anchor to the shape");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("peCreateService.createChopboxAnchor(containerShape);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// call the update and layout features");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("updatePictogramElement(containerShape);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("layoutPictogramElement(containerShape);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return containerShape;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean hasDoneChanges() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public boolean canUndo(IContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}