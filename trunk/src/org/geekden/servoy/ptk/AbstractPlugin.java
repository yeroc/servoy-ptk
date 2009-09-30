package org.geekden.servoy.ptk;

import java.util.Properties;

import com.servoy.j2db.plugins.IPlugin;
import com.servoy.j2db.plugins.PluginException;

abstract class AbstractPlugin implements IPlugin
{
  private final String displayName;

  protected AbstractPlugin(String displayName)
  { this.displayName = displayName; }
  
  public Properties getProperties()
  {
    Properties props = new Properties();
    props.put(IPlugin.DISPLAY_NAME, displayName);
    return props; 
  }

  public void load() throws PluginException { }
  
  public void unload() throws PluginException { }

  protected final String getDisplayName()
  { return displayName; }
}
