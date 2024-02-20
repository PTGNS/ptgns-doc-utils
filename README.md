# PTGNS Docs Utils

## Introduction

Welcome to PTGNS Doc Utils, a collection of simplified functions aimed at easing PDF creation using the iText library.
This open-source project strives to streamline the process of generating PDF documents by providing developers with
easy-to-use utilities.

Possible Implementation:
- Standalone PDF Hosting (Non-commercial)
- Utils integration with existing Open Source project

## Feature

- **Simplified Functions:** PTGNS Doc Utils offers a set of simplified functions that abstract away the complexities of
  PDF generation using iText.
- **Ease of Use:** Developers can quickly host these utilities to handle PDF documents generation with minimal effort.
- **Modular Design:** The project is designed with modularity in mind, allowing developers to easily extend or customize
  functionality to suit their specific requirements.
- **Grid View:** Enable griding view to ease positioning of such element into the pdf

## Getting Started

To begin using PTGNS Doc Utils, clone the repository and directly integrate the provided functions into your project.
The project includes all necessary dependencies, making setup effortless.

```
git clone https://github.com/your-username/ptgns-doc_utils.git
```

## Utils

The utils created are classified as such:

- **DocCellUtil**
- **DocTitleUtil**
- **DocTableUtil**
- **DocParagraphUtil**
- **DocPhraseUtil**
- **DocColumnUtil**
- **DocFontUtil:** Font setup
- **SystemUtils:** Comprised of general utils such as date/currency formatting

## Grid

The grid setup can be found in `system.properties` with option as below:

```
sys.pdf.grid=false|true
sys.pdf.grid.size.parent=100
sys.pdf.grid.size.child=10
```
Example:
![grid-example.png](src%2Fmain%2Fwebapp%2Fresources%2Fimg%2Fgrid-example.png)

## Font

Font setup can also be found in `system.properties` with option as below:

```
sys.pdf.font=COURIER|COURIER_OBLIQUE|COURIER_BOLDOBLIQUE|HELVETICA|
             HELVETICA_BOLD|HELVETICA_OBLIQUE|HELVETICA_BOLDOBLIQUE|
             SYMBOL|TIMES|TIMES_ROMAN|TIMES_BOLD|TIMES_ITALIC|
             TIMES_BOLDITALIC|ZAPFDINGBATS
sys.pdf.font.style=NORMAL|BOLD|ITALIC|UNDERLINE|STRIKETHRU|BOLDITALIC
sys.pdf.font.size=11
```

## Sample

We have provided 2 type of example:

- **Billing:** Sample of how to write on PDF Template with positioning
- **Text Doc:** Sample on how to write simple text document with various utils implementation

### Billing Sample

- **Controller:** BillingSampleController
- **Viewer:** BillingSample
- **Usage/Example:** DocFontUtil, DocColumnUtil, Grid View, Import pdf template
- **Description:** In this example, we demonstrated the simplification on rendering text on a predefined space. With the gridview enable the positioning can be identified quickly. The data population also can be done within a single function call.

### Text Doc Sample

- **Controller:** DocSampleController
- **Viewer:** DocSample
- **Usage/Example:** DocFontUtil, DocTitleUtil, DocTableUtil, DocParagraphUtil, DocPhraseUtil
- **Description:** The sample consist alot of util utilization which demonstrated the capabilty of PTGNS Doc Utils. With correct implmentation a complex view of a text document can be achieve.


## Stack

- **Spring Framework:** 4.3.16
- **Pebble:** 2.4.0
- **iText PDF:** 5.5.1
