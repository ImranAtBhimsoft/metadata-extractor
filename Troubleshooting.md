# Troubleshooting #

## Adobe XMP Parsing Exception ##

### AbstractMethodError ###

Some users observe an exception from Adobe's XMP library:

```
java.lang.AbstractMethodError: javax.xml.parsers.DocumentBuilderFactory.setFeature
    at com.adobe.xmp.impl.XMPMetaParser.createDocumentBuilderFactory
    at com.adobe.xmp.impl.XMPMetaParser.<clinit>
    at com.adobe.xmp.XMPMetaFactory.parseFromBuffer
    at com.adobe.xmp.XMPMetaFactory.parseFromBuffer
    at com.drew.metadata.xmp.XmpReader.extract
    at com.drew.imaging.jpeg.JpegMetadataReader.extractMetadataFromJpegSegmentReader
    at com.drew.imaging.jpeg.JpegMetadataReader.readMetadata
    at com.drew.imaging.ImageMetadataReader.readMetadata
    at com.drew.imaging.ImageMetadataReader.readMetadata
```

Normally, metadata-extractor will catch exceptions and flag certain metadata directories as having parse problems, however this [AbstractMethodException](http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/AbstractMethodError.html) is a subclass of `Error` which is considered _uncatchable_, at least according to good practice.

This specific error is described as follows:

> Normally, this error is caught by the compiler; this error can only occur at run time if the definition of some class has incompatibly changed since the currently executing method was last compiled.

Therefore you can reason that an unexpected version of a jar is being used at runtime.

Some [users have said](http://code.google.com/p/metadata-extractor/issues/detail?id=34) that this can be caused by an incompatible version of `xercesImpl.jar`.

### NoClassDefFoundError ###

Other users have [reported problems](http://code.google.com/p/metadata-extractor/issues/detail?id=41) resulting in an exception resembling:

```
java.lang.NoClassDefFoundError: com/adobe/xmp/XMPException
    at com.drew.imaging.jpeg.JpegMetadataReader.extractMetadataFromJpegSegmentReader
    at com.drew.imaging.jpeg.JpegMetadataReader.readMetadataSource)
    at com.drew.imaging.ImageMetadataReader.readMetadata
    at com.drew.imaging.ImageMetadataReader.readMetadata
```

This suggests that `xmpcore.jar` is not available in your classpath.    This jar file is included with the zip file in the downloads section.