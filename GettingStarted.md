Using this library is straightforward.  Conceptually there are two steps to its usage:

  1. Read a `Metadata` object from an image
  1. Query the `Metadata` object to retrieve one or more values

**NOTE:**

  * These examples are based upon version 2.5.0 of the API.  Earlier versions differ slightly.
  * Import statements and exception handling code have been omitted for clarity.
  * A fully-featured sample class is available in the source distribution.


---


# 1. Read `Metadata` #

## From a File ##

For an image file of any supported type, use:

```
File jpegFile = new File("myImage.jpg");
Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
```

If you know the type of file, you can replace `ImageMetadataReader` with the specific reader, for example `JpegMetadataReader`.

## From a stream ##

Reading from a stream is much the same, however you can specify whether Metadata Extractor should attempt to retry if bytes were unavailable on the stream.  This can be useful if you are reading image data from a network source, for example.

```
Metadata metadata = ImageMetadataReader.readMetadata(stream, waitForBytes);
```


---


# 2. Query `Tag`s #

A `Metadata` object contains zero or more `Directory` objects.  These in turn contain zero or more `Tag` objects.  Tags hold values representing the metadata for the source image.

## Print out all `Tag` values ##

```
for (Directory directory : metadata.getDirectories()) {
    for (Tag tag : directory.getTags()) {
        System.out.println(tag);
    }
}
```

## Query the raw value of a specific `Tag` ##

```
// obtain the Exif directory
ExifSubIFDDirectory directory = metadata.getDirectory(ExifSubIFDDirectory.class);

// query the tag's value
Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
```

Note that tag values have specific data types.  Attempts will be made to convert to the type you request, but this is not always possible.

## Query a decoded description of a specific `Tag` ##

If you only wish to display a friendly string version of the tag's value, simply call `Tag.toString()`.  Alternatively, you can wrap the directory with a `Descriptor` and have strongly-typed access with descriptive method names:

```
// obtain a specific directory
Directory directory = metadata.getDirectory(ExifSubIFDDirectory.class);

// create a descriptor
ExifSubIFDDescriptor descriptor = new ExifSubIFDDescriptor(exifDirectory);

// get tag description
String program = descriptor.getExposureProgramDescription();
```

In the above example, `program` would contain a detailed string such as `"Manual control"` or `"Aperture Priority"`, whereas the raw tag value is actually an integer.  Descriptors not only decode enum values, but also prepend/append units (`"-1 EV"`, `"F2.8"`) and provide methods that calculate derived properties for convenience.