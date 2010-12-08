/**
 * Copyright 2009-2010 Corey Puffalt
 *
 * This file is part of Servoy Plugin Toolkit.
 *
 * Servoy Plugin Toolkit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Servoy Plugin Toolkit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Servoy Plugin Toolkit.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.geekden.servoy.ptk;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;

import com.servoy.j2db.plugins.IClientPlugin;
import com.servoy.j2db.plugins.IClientPluginAccess;
import com.servoy.j2db.plugins.PluginException;
import com.servoy.j2db.preference.PreferencePanel;

public abstract class AbstractClientPlugin extends AbstractPlugin implements IClientPlugin
{
  private final String name;
  
  protected AbstractClientPlugin(String name, String displayName)
  { 
    super(displayName);
    this.name = name;
  }
  
  /**
   * 
   * @see com.servoy.j2db.plugins.IClientPlugin#getName()
   **/
  public final String getName()
  { return name; }
  
  /**
   * An empty implementation for those plugins that don't need a reference to
   * IClientPluginAccess.
   * 
   * @see com.servoy.j2db.plugins.IClientPlugin#initialize(com.servoy.j2db.plugins.IClientPluginAccess)
   **/
  public void initialize(IClientPluginAccess context) throws PluginException { }

  /**
   * Returns null which results in Servoy rendering the plugin with a default
   * icon in the developer GUI.  Override this method to return a custom icon.
   * 
   * @see com.servoy.j2db.plugins.IClientPlugin#getImage()
   **/
  public Icon getImage()
  { return null; }

  public void propertyChange(PropertyChangeEvent evt) { }
  
  /** @deprecated No longer used according to the documentation **/
  public final PreferencePanel[] getPreferencePanels() { return null; }
}
