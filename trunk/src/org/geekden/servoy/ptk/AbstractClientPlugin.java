/**
 * Copyright 2009 Corey Puffalt
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
