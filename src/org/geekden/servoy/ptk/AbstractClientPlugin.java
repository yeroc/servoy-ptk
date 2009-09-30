package org.geekden.servoy.ptk;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;


import com.servoy.j2db.plugins.IClientPlugin;
import com.servoy.j2db.preference.PreferencePanel;

public abstract class AbstractClientPlugin extends AbstractPlugin implements IClientPlugin
{
  private final String name;
  private Icon icon;
  
  protected AbstractClientPlugin(String name, String displayName)
  { 
    super(displayName);
    this.name = name;
  }
  
  public final String getName()
  { return name; }
  
  public Icon getImage()
  { 
    if (icon == null) icon = new ImageIcon(AbstractClientPlugin.class.getResource("plugin.png"));
    return icon; 
  }
  
  /** @deprecated No longer used according to the documentation **/
  public final PreferencePanel[] getPreferencePanels()
  { return null; }

  public void propertyChange(PropertyChangeEvent evt) { }

}
