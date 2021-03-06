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
package org.geekden.servoy.plugin.logger;

import org.geekden.servoy.ptk.AbstractClientPlugin;
import org.geekden.servoy.ptk.AbstractScriptObject;
import org.geekden.servoy.ptk.Export;

import com.servoy.j2db.scripting.IScriptObject;

public class Log4jPlugin extends AbstractClientPlugin
{
  private Log4jProvider provider = null;
  
  public Log4jPlugin()
  { super("log4j", "Log4j Plugin"); }

  public IScriptObject getScriptObject()
  {
    if (provider == null) provider = new Log4jProvider();
    return provider;
  }

  public static class Log4jProvider extends AbstractScriptObject
  {
    public Log4jProvider()
    { register(Log.class); }
    
    @Export(
      parameters = { "name" }, 
      tooltip = "Create a Logger",
      sample = "var log = %%elementName%%.getLogger('mylogger');")
    public Log js_getLogger(String name)
    { return new Log(name); }
  }
}
