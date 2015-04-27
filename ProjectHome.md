# THIS PROJECT HAS MOVED TO GITHUB #

## Please visit https://github.com/drewnoakes/metadata-extractor ##

<a href='Hidden comment: 

---

**metadata-extractor** is a straightforward Java library for reading metadata from image files.

```
Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
```

With that metadata object, you can [http://code.google.com/p/metadata-extractor/wiki/GettingStarted#2._Query_Tag_s iterate or query] the [http://code.google.com/p/metadata-extractor/wiki/SampleOutput various tag values] that were read from the image.

The library understands several formats of metadata, many of which may be present in a single image:

<table border="0">
<tr>
<td valign="top">
* [http://en.wikipedia.org/wiki/Exchangeable_image_file_format Exif]
* [http://en.wikipedia.org/wiki/IPTC IPTC]
* [http://en.wikipedia.org/wiki/Extensible_Metadata_Platform XMP]
* [http://en.wikipedia.org/wiki/JPEG_File_Interchange_Format JFIF / JFXX]
* [http://en.wikipedia.org/wiki/ICC_profile ICC Profiles]


Unknown end tag for &lt;/td&gt;


<td valign="top">
* [http://en.wikipedia.org/wiki/Photoshop Photoshop] fields
* [http://en.wikipedia.org/wiki/Portable_Network_Graphics PNG] properties
* [http://en.wikipedia.org/wiki/BMP_file_format BMP] properties
* [http://en.wikipedia.org/wiki/Graphics_Interchange_Format GIF] properties


Unknown end tag for &lt;/td&gt;




Unknown end tag for &lt;/tr&gt;




Unknown end tag for &lt;/table&gt;


It will process files of type:

<table border="0">
<tr>
<td valign="top">
* JPEG
* TIFF
* PSD
* PNG


Unknown end tag for &lt;/td&gt;


<td valign="top">
* BMP
* GIF
* Camera Raw (NEF/CR2/ORF/ARW/RW2/...)


Unknown end tag for &lt;/td&gt;




Unknown end tag for &lt;/tr&gt;




Unknown end tag for &lt;/table&gt;



Special camera-specific data is decoded for most cameras manufactured by:

<table border="0">
<tr>
<td valign="top">
* Agfa
* Canon
* Casio
* Epson
* Fujifilm
* Kodak


Unknown end tag for &lt;/td&gt;


<td valign="top">
* Kyocera
* Leica
* Minolta
* Nikon
* Olympus
* Panasonic


Unknown end tag for &lt;/td&gt;


<td valign="top">
* Pentax
* Sanyo
* Sigma/Foveon
* Sony


Unknown end tag for &lt;/td&gt;




Unknown end tag for &lt;/tr&gt;




Unknown end tag for &lt;/table&gt;



Read [GettingStarted] for an introduction to the basics of using this library.

==Mailing Lists==

Three mailing lists exist:

# [http://groups.google.com/group/metadata-extractor-announce metadata-extractor-announce] for read-only announcements of new releases
# [http://groups.google.com/group/metadata-extractor-dev metadata-extractor-dev] for discussion about development and notifications of changes to issues and source code

==Credits==

This library is developed by [http://drewnoakes.com/code/exif/ Drew Noakes].

Thanks are due to the many [http://code.google.com/p/metadata-extractor/wiki/UsedBy users] who sent in suggestions, bug reports, [http://code.google.com/p/metadata-extractor/wiki/ImageDatabase sample images] from their cameras as well as encouragement.  Wherever possible, they have been credited in the source code and commit logs.

==Feedback==

Have questions?  Try the [http://groups.google.com/group/metadata-extractor-dev mailing list].

Found a bug or have a patch?  Search the [http://code.google.com/p/metadata-extractor/issues/list issue list] and if it isn"t already there, create it.

==Contribute==

The easiest way to help is to contribute to the [http://code.google.com/p/metadata-extractor/wiki/ImageDatabase sample image file library] used for research and testing.

If you want to get your hands dirty, clone this repository, enhance the library and let us know to pull from your clone. Ask around on the mailing list to avoid duplication of work.

<wiki:gadget border="0" url="http://stefansundin.com/stuff/flattr/google-project-hosting.xml" width="55" height="62" up_uid="drewnoakes" up_title="Metadata Extractor for Java" up_cat="software" up_desc="Metadata Extractor lets you access the metadata in digital images via a simple Java API." up_tags="java,exif,iptc,xmp,metadata,imaging,jpeg,tiff,nef,crw,cr2,software,software library" up_url="http://drewnoakes.com/code/exif/" />

<a href="http://flattr.com/thing/181972/Metadata-Extractor-for-Java" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" />

Unknown end tag for &lt;/a&gt;



<wiki:gadget url="http://www.ohloh.net/p/478132/widgets/project_factoids.xml" height="170" width="345" border="0"/>
'></a>