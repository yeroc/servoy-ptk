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
