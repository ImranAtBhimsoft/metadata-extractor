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
package com.drew.metadata.jpeg;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataReader;

import java.io.File;
import java.io.InputStream;

/**
 * Decodes the comment stored within Jpeg files, populating a <code>Metadata</code> object with tag values in a
 * <code>JpegCommentDirectory</code>.
 *
 * @author Drew Noakes http://drewnoakes.com
 */
public class JpegCommentReader implements MetadataReader
{
    /**
     * The COM data segment.
     */
    private final byte[] _data;

    /**
     * Creates a new JpegReader for the specified Jpeg jpegFile.
     */
    public JpegCommentReader(File jpegFile) throws JpegProcessingException
    {
        this(new JpegSegmentReader(jpegFile).readSegment(JpegSegmentReader.SEGMENT_COM));
    }

    /**
     * Creates a JpegCommentReader for a JPEG stream.
     * @param is JPEG stream. Stream will be closed.
     */
    public JpegCommentReader(InputStream is) throws JpegProcessingException
    {
        this(new JpegSegmentReader(is).readSegment(JpegSegmentReader.SEGMENT_APPD));
    }

    /**
     * Creates a JpegCommentReader for raw JPEG data.
     * @param data JPEG data as a byte[].
     */
    public JpegCommentReader(byte[] data)
    {
        _data = data;
    }

    /**
     * Performs the Jpeg data extraction, adding found values to the specified
     * instance of <code>Metadata</code>.
     */
    public void extract(Metadata metadata)
    {
        if (_data==null)
            return;

        JpegCommentDirectory directory = (JpegCommentDirectory)metadata.getDirectory(JpegCommentDirectory.class);

        directory.setString(JpegCommentDirectory.TAG_JPEG_COMMENT, new String(_data));
    }
}
