### Can I write metadata back to files? ###

Not as of yet.  The architecture of the library is steadily heading that way, but it's not possible today.

Don't be mislead by the various setter methods on `Directory` objects.

### I just want to know _when_ a photo was taken.  How do I do that? ###

```
Metadata metadata = ImageMetadataReader.readMetadata(file);

ExifSubIFDDirectory directory = metadata.getDirectory(ExifSubIFDDirectory.class);

Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
```

More code samples at [GettingStarted](GettingStarted.md).

### I just want to know _where_ a photo was taken.  How do I do that? ###

```
Metadata metadata = ImageMetadataReader.readMetadata(file);

GpsDirectory directory = metadata.getDirectory(GpsDirectory.class);

GeoLocation location = directory.getGeoLocation();
```

More code samples at [GettingStarted](GettingStarted.md).

### Ok, I see the pattern. What about other fields? ###

Browse the source code or the [JavaDoc](http://javadoc.metadata-extractor.googlecode.com/git/) to discover the full set of tags available on all directories, as well as helper methods like `getGetLocation()` above.

### My camera has some special features.  Are they supported? ###

Camera manufacturers store information that specific to the model of camera being used in a devoted section known as a _makernote_.  Metadata Extractor  has good support for many manufacturer makernotes, but new cameras are being produced all the time.

If you see a lot of unknown tag values being output for images from your camera, you can help to decode them!

Firstly, look online and see whether they're documented somewhere.  Manufacturers rarely release official specifications, but someone may have already held a successful investigation.

If there's no information available out there, then grab your camera and start trying various settings and seeing which values change in your image.  A little time spent as a detective may uncover the meaning of one or more makernote tags.

However you find the answer, if Metadata Extractor doesn't understand the tag then either update the code yourself and [send in a patch](http://code.google.com/p/metadata-extractor/issues/entry), or document your findings in a [feature request](http://code.google.com/p/metadata-extractor/issues/entry).

### Can I use this library from JRuby? ###

An unknown author produced a [great example of this on pastebin](http://pastebin.com/HAFgPFja).