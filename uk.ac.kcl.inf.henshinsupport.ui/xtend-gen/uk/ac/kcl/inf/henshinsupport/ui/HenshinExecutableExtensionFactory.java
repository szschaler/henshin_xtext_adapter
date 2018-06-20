package uk.ac.kcl.inf.henshinsupport.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import uk.ac.kcl.inf.henshinsupport.ui.Activator;

/**
 * Instantiates classes declared in the plugin.xml using the DI container.
 */
@SuppressWarnings("all")
public class HenshinExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {
  @Override
  protected Bundle getBundle() {
    return Activator.getDefault().getBundle();
  }
  
  @Override
  protected Injector getInjector() {
    return Activator.getDefault().getInjector();
  }
}
