/*
 * Copyright 2002-2011 Drew Noakes
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    http://drewnoakes.com/code/exif/
 *    http://code.google.com/p/metadata-extractor/
 */
package com.drew.metadata;

import java.io.Serializable;

/**
 * Abstract base class for all tag descriptor classes.  Implementations are responsible for
 * providing the human-readable string representation of tag values stored in a directory.
 * The directory is provided to the tag descriptor via its constructor.
 *
 * @author Drew Noakes http://drewnoakes.com
 */
public abstract class TagDescriptor implements Serializable
{
    // TODO getDescription should return null instead of throwing MetadataException
    
    protected final Directory _directory;

    public TagDescriptor(Directory directory)
    {
        _directory = directory;
    }

    /**
     * Returns a descriptive value of the the specified tag for this image.
     * Where possible, known values will be substituted here in place of the raw
     * tokens actually kept in the Exif segment.  If no substitution is
     * available, the value provided by getString(int) will be returned.
     * 
     * @param tagType the tag to find a description for
     * @return a description of the image's value for the specified tag, or
     *         <code>null</code> if the tag hasn't been defined.
     */
    public abstract String getDescription(int tagType) throws MetadataException;
}
