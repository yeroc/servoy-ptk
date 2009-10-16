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

/**
 * An internal class used to hold the information associated with a
 * method that has been exposed by an IScriptObject class.
 * 
 * @author Corey Puffalt
 */
class MethodInfo
{
  private final String name;
  private final String[] parameters;
  private final String sample;
  private final String tooltip;
  private final boolean deprecated;
  
  private MethodInfo(String name, String[] parameters, String sample, String tooltip, boolean deprecated)
  {
    this.name = name;
    this.parameters = parameters;
    this.sample = sample;
    this.tooltip = tooltip;
    this.deprecated = deprecated;
  }
  
  public String name() { return name; }
  public String[] parameters() { return parameters; }
  public String sample() { return sample; }
  public String tooltip() { return tooltip; }
  public boolean deprecated() { return deprecated; }
  
  public static Builder method(String name)
  { return new Builder(name); }
  
  public static final class Builder
  {
    private String name = "";
    private String[] parameters = new String[] {};
    private String sample = "";
    private String tooltip = "";
    private boolean deprecated = false;
    
    public Builder(String name) { this.name = name; }
    public Builder parameters(String... parms) { this.parameters = parms; return this; }
    public Builder sample(String sample) { this.sample = sample; return this; }
    public Builder tooltip(String tooltip) { this.tooltip = tooltip; return this; }
    public Builder deprecated(boolean deprecated) { this.deprecated = deprecated; return this; }
    
    public MethodInfo build()
    { return new MethodInfo(name, parameters, sample, tooltip, deprecated); }
  }
}
