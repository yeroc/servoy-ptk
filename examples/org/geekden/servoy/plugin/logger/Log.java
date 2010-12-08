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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.geekden.servoy.ptk.AbstractScriptObject;
import org.geekden.servoy.ptk.Export;

public class Log extends AbstractScriptObject
{
  private final Logger log;
  
  /**
   * This public no-arg constructor is required so that Developer can create
   * an instance of this object to interrogate for information about
   * method parameters, tooltips and samples etc.  The class is otherwise
   * non-functional when constructed in this manner.
   */
  public Log() 
  { log = null; }
  
  public Log(String name)
  { log = Logger.getLogger(name); }
  
  @Export
  public void js_trace(Object msg)
  { log(Level.TRACE, msg); }

  @Export
  public void js_debug(Object msg)
  { log(Level.DEBUG, msg); }
  
  @Export(
    parameters = { "msg" },
    tooltip = "Log an informative message.",
    sample = "log.info('msg');")
  public void js_info(Object msg)
  { log(Level.INFO, msg); }

  @Export
  public void js_warn(Object msg)
  { log(Level.WARN, msg); }
  
  @Export
  public void js_error(Object msg)
  { log(Level.ERROR, msg); }

  private void log(Level l, Object msg)
  { log.log(Log.class.getName(), l, msg, null); }
}