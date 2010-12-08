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
