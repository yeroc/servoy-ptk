package org.geekden.servoy.ptk;

import java.util.HashMap;
import java.util.Map;


import com.servoy.j2db.plugins.IServerPlugin;
import com.servoy.j2db.preference.PreferencePanel;

public abstract class AbstractServerPlugin extends AbstractPlugin implements IServerPlugin
{
  /** Contains the property name as the key with a description as the value **/
  private final Map<String, String> requiredProperties = new HashMap<String, String>();
  
  protected AbstractServerPlugin(String displayName)
  { super(displayName); }

  /** @deprecated No longer used according to the documentation **/
  public PreferencePanel[] getPreferencePanels()
  { return null; }

  public Map<String, String> getRequiredPropertyNames()
  { return requiredProperties; }

  protected void registerProperty(String prop, String description)
  { requiredProperties.put(prop, description); }
}
