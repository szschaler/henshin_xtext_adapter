package uk.ac.kcl.inf.util.henshinsupport;

import java.util.Arrays;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.NamedElement;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class NamingHelper {
  protected static String _name(final EObject eo) {
    return null;
  }
  
  protected static String _name(final NamedElement ne) {
    return ne.getName();
  }
  
  protected static String _name(final Edge e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    String _name = e.getSource().getName();
    _builder.append(_name);
    _builder.append("->");
    String _name_1 = e.getTarget().getName();
    _builder.append(_name_1);
    _builder.append(":");
    String _name_2 = e.getType().getName();
    _builder.append(_name_2);
    _builder.append("]");
    return _builder.toString();
  }
  
  protected static String _name(final Attribute a) {
    String _xifexpression = null;
    EAttribute _type = a.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      _xifexpression = a.getType().getName();
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public static String name(final EObject a) {
    if (a instanceof Attribute) {
      return _name((Attribute)a);
    } else if (a instanceof Edge) {
      return _name((Edge)a);
    } else if (a instanceof NamedElement) {
      return _name((NamedElement)a);
    } else if (a != null) {
      return _name(a);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a).toString());
    }
  }
}
