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

import static org.geekden.servoy.ptk.MethodInfo.method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.servoy.j2db.scripting.IScriptObject;

public abstract class AbstractScriptObject implements IScriptObject
{
  private static final Logger log = Logger.getLogger(AbstractScriptObject.class);
  
  private final Map<String, MethodInfo> methods = 
    new HashMap<String, MethodInfo>();
  private final Set<Class<? extends IScriptObject>> types = 
    new HashSet<Class<? extends IScriptObject>>();
  
  private boolean annotatedMethodsRegistered = false;
  
  public Class<?>[] getAllReturnedTypes()
  { return types.toArray(new Class[types.size()]); }

  public final String[] getParameterNames(String method)
  { return lookup(method).parameters(); }

  public final String getSample(String method)
  { return lookup(method).sample(); }

  public final String getToolTip(String method)
  { return lookup(method).tooltip(); }

  public final boolean isDeprecated(String method)
  {
    MethodInfo m = lookup(method);
    return m != null ? lookup(method).deprecated() : false; 
  }

  /**
   * Exposed to allow registering a method manually as opposed to using
   * annotations.
   * 
   * @param m
   **/
  protected void register(MethodInfo m)
  { methods.put(m.name(), m); }
  
  protected void register(Class<? extends IScriptObject> clazz)
  { types.add(clazz); }
  
  private MethodInfo lookup(String method)
  {
    if (!annotatedMethodsRegistered) { registerMethodsFromAnnotations(); }
    MethodInfo m = methods.get(method);
    return m;
  }

  private void registerMethodsFromAnnotations()
  {
    MethodInfo m = null;

    for (Method mtd : getClass().getMethods()) 
    {
      if (Modifier.isPublic(mtd.getModifiers()) &&
          mtd.isAnnotationPresent(Export.class) &&
          mtd.getName().startsWith("js_"))
      {
        Export exp = mtd.getAnnotation(Export.class);
        // the name is actually the method name without the js_ prefix...
        m = method(mtd.getName().substring(3)) 
          .parameters(exp.parameters())
          .sample(exp.sample() == Export.NULL ? null : exp.sample())
          .tooltip(exp.tooltip() == Export.NULL ? null : exp.tooltip())
          .deprecated(mtd.isAnnotationPresent(Deprecated.class))
          .build();
        register(m);
      }
    }
    annotatedMethodsRegistered = true;
  }
}
