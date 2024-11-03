---
layout: page
title: User Guide
---

PROperty is a **desktop app for property agents managing contacts and their property listings,
optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).
If you can type fast, PROperty can get your contact and property management tasks done faster than traditional GUI apps.

PROperty is useful for property agents because it saves their time by allowing easy tracking of contacts,
and easily filtering them according to tailor-made categories relevant to property agents in Singapore. It taps on the
fact that it is a lot less complicated to operate than its competitors such as Microsoft Excel while being faster to
operate than graphical user interfaces commonly found in smartphones.

## Table of Contents
* [Quick start](#quick-start)
* [Features](#features)
    * [Adding a person: `add`](#adding-a-person-add)
    * [Listing all persons : `list`](#listing-all-persons--list)
    * [Editing a person : `edit`](#editing-a-person--edit)
    * [Locating persons by name: `find`](#locating-persons-by-name-find)
    * [Locating persons by tag: `findtag`](#locating-persons-by-tag-findtag)
    * [Deleting a person : `delete`](#deleting-a-person--delete)
    * [Clearing all entries : `clear`](#clearing-all-entries--clear)
    * [Exiting the program : `exit`](#exiting-the-program--exit)
    * [Quick reference help: `help`](#quick-reference-help-help)
    * [Managing Remarks : `remark`](#managing-remarks--remark)
    * [Showing property listings of a person : `show`](#showing-property-listings-of-a-person--show)
    * [Adding a property listing : `listing add`](#adding-a-property-listing--listing-add)
    * [Deleting a property listing : `listing delete`](#deleting-a-property-listing--listing-delete)
* [Saving the data](#saving-the-data)
* [Editing the data file](#editing-the-data-file)
* [Archiving data files `[coming in v2.0]`](#archiving-data-files-coming-in-v20)
* [FAQ](#faq)
* [Known issues](#known-issues)
* [Command summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.

2. Download the latest `.jar` file from [here](https://github.com/AY2425S1-CS2103T-F15-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your PROperty.

4. Double-click on the `.jar` file to run it
   - **For advanced users:** Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar PROperty.jar` command to run the application.<br>

- A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:
   
   * `list` : Lists all contacts.
   
   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a client named `John Doe` to PROperty.
   
   * `delete 3` : Deletes the 3rd contact shown in the current list.
   
   * `clear` : Deletes all contacts.
   
   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/seller` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/seller`, `t/seller t/landlord` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  

</div>


### Adding a person: `add`

Adds a person to PROperty.

Format: `add n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [t/PERSON_TAG] [r/REMARKS]…​`

- `NAME` and `PHONE_NUMBER` fields must be provided.
-  Refer to the [Tag Table](#tag-table) for a complete list of person tags.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including no tags)
</div>

Examples:

* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 r/looking for HDB`
* `add n/Betsy Crowe t/condo e/betsycrowe@example.com a/Flatbush Avenue, block 81, #02-02 p/1234567`


### Listing all persons : `list`

Shows a list of all persons in the PROperty.

Format: `list`


### Editing a person : `edit`

Edits an existing person in the PROperty.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/PERSON_TAG] [dt/PERSON_TAG] [r/REMARK]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* `PERSON_TAG` can be `Buyer`, `Seller`, `Landlord`, `Tenant`
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the tags specified using `t/` will be added to the contact (cumulatively).
* Tags can also be removed using the delete tag `dt/` prefix, followed by the tag name.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:

* `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
* `edit 2 t/condo` Adds the tag `condo` to the 2nd person

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`.
* By default, the find command conduct a general search for the individual. Hence, 
the order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
* A person's name, phone nunmber, address, email and tag can be searched.
* Only full words will be matched e.g. `Han` will not match `Hans`.
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* If a more specific search is required, utilise the `s/`.
  * Format: `find s/KEYWORD [s/MORE_KEYWORDS]`
  * Only individuals who match the keyword(s) one-to-one will be returned. e.g. `find s/Hans Bo` will not match `Bo Hans`. `find s/Hans Bo` will only match `Hans Bo`.
  * Especially useful if there are multiple people with the same name in PROperty and you require a more specific search.

Examples:

* `find John` returns `John` and `John Doe`.
* `find s/John` returns only `John`.
* `find alex david` returns `Alex Yeoh`, `David Li`.
* `find s/Alex Yeoh s/23 Smith Street` returns `Alex Yeoh` who has `23 Smith Street` as his address.

![Find Command](images/findCommand.png)

### Locating persons by tag: `findtag`

Finds persons whose tags contain any of the given words.

Format: `findtag TAG [MORE_TAGS]`

- The search is case-insensitive. e.g., `HDB` will match `hdb`.
- The order of the tags does not matter.
- Persons with at least one matching tag will be returned (i.e., an `OR` search).
- List of possible tags you can search for are found in the [Tag Table](#tag-table)

Examples:

- `findtag HDB` returns persons tagged with `HDB`.
- `findtag HDB buyer` returns persons tagged with either `HDB` or `buyer`.

![Find tag command](images/findtagCommand.png)

### Deleting a person : `delete`

Deletes the specified person from the PROperty.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:

* `list` followed by `delete 2` deletes the 2nd person in PROperty.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.


### Clearing all entries : `clear`

Clears all entries from the PROperty.

Format: `clear`


### Exiting the program : `exit`

Exits the program.

Format: `exit`


### Quick reference help: `help`

Shows commands in a help menu for quick reference during use of PROperty.

![help message](images/helpMessage.png)

Format: `help`


### Managing Remarks : `remark`

Adds/removes a remark from a person in PROperty.

Format: `remark INDEX r/[REMARKS]`

- Adds a remark `REMARKS` to the person at `INDEX`

- The index refers to the index number shown in the displayed person list.

- The index **must be a positive integer** 1, 2, 3, …​

- **Note:** `[REMARKS]` will **delete the remark if left blank**

Examples:

- `remark 1 r/Prefers a higher floor apartment`
  
  - Adds a remark "Prefers a higher floor apartment" to the person at index `1`

- `remark 1 r/`
  
  - Deletes the remark of person at index `1`


### Showing property listings of a person : `show`

Shows the full details of the specified person, including their property listings.

Format: `show INDEX`

- Shows the person at the specified `INDEX`
- The `INDEX` refers to the index number shown in the displayed person list.
- The `INDEX` **must be a positive integer** 1, 2, 3, …​

Examples: 

- `show 2` shows the name, contact information, tags, and property listings of the second person in the PROperty.

![Show Command](images/showCommand.png)

### Adding a property listing : `listing add`

Adds a property listing to the person specified by `INDEX`

Format: `listing add INDEX t/[PROPERTY_TAG] a/[LISTING_ADDRESS]`

- Adds a property listing to the person specified by `INDEX`
- The `INDEX` refers to the index number shown in the displayed person list.
- The `INDEX` **must be a positive integer** 1, 2, 3, …​
- Refer to the [Tag Table](#tag-table) for a complete list of property tags.

Examples:

- `listing add 1 t/condo a/NUS street 123` adds a property listing to the person at index `1` with a listing type of `condo` and address of `NUS street 123`

### Deleting a property listing : `listing delete`

Deletes the property listing with index `LISTING_INDEX` from the person specified by `INDEX` 

Format: `listing delete INDEX LISTING_INDEX`

- Adds the property listing with index `LISTING_INDEX` to the person specified by `INDEX`
- The `INDEX` refers to the index number shown in the displayed person list.
- The `LISTING_INDEX` refers to the index number shown in the property listing displayed by the `show` command
- The `INDEX`/`LISTING_INDEX` **must be a positive integer** 1, 2, 3, …​

Examples:

- `listing delete 1 1` deletes the `1`st property listing from the person with index `1`


### Exporting your contacts : `export`

Exports your contacts and their relevant data to a Comma-Separated Value (CSV) file format.

Format: `export`

- Headings of the CSV file will be the attributes of an individual (ie Name, Address, Phone number etc)
- If an individual listings and/or tags attributed to them, the listings and/or tags are separated by a semicolon.
- By default, the exported CSV file will be located in the "data" folder with the name "property.csv"

### Sorting all persons : `sort`

Sorts the list of all persons in the address book by name in alphabetical order.

Format: `sort`

### Saving the data

PROperty data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


### Editing the data file

PROperty data are saved automatically as a JSON file `[JAR file location]/data/property.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, PROperty will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the PROperty to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>


### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous PROperty home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action             | Format, Examples                                                                                                                                                                |
|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**            | `add n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [t/PERSON_TAG] [r/REMARKS]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/buyer` |
| **Clear**          | `clear`                                                                                                                                                                         |
| **Delete**         | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                             |
| **Edit**           | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG] [r/REMARKS]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                         |
| **Find**           | `find KEYWORD [MORE_KEYWORDS]`<br/>`find s/KEYWORD [s/MORE_KEYWORDS]`<br> e.g., `find James Jake`, `find s/James Jake s/23 Philip Street`                                       |
| **Findtag**        | `findtag TAG [MORE_TAGS]`<br> e.g., `findtag friend colleague`                                                                                                                  |
| **List**           | `list`                                                                                                                                                                          |
| **Findtag**        | `findtag TAG [MORE_TAGS]`<br> e.g., `findtag hdb buyer`                                                                                                                         |
| **List**           | `list`                                                                                                                                                                          
| **Add Listing**    | `listing add INDEX t/[PROPERTY_TAG] a/[LISTING_ADDRESS]`<br> e.g., `listing add 1 t/condo a/123 NUS Street`                                                                     |
| **Delete Listing** | `listing delete INDEX LISTING_INDEX `<br> e.g., `listing delete 1 1`                                                                                                            |
| **Show**           | `show INDEX`<br> e.g., `show 1`                                                                                                                                                 |
| **Sort**           | `sort`                                                                                                                                                                          |
| **Help**           | `help`                                                                                                                                                                          |
| **Remark**         | `remark INDEX r/[REMARKS]`                                                                                                                                                      |
| **Export**         | `export`                                                                                                                                                                        |

--------------------------------------------------------------------------------------------------------------------

## Tag Table

| Tag Type | Tags                                                                                                                                                                      |
|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Property | HDB, CONDO, RESIDENTIAL, LANDED, EC, COMMERCIAL, RETAIL, INDUSTRIAL, OFFICE, WAREHOUSE, SHOPHOUSE, TERRACE, SEMIDET, BUNGALOW, DETACHED, GCB, PENTHOUSE, MIXED, SERVAPT, DORM |
| Person   | BUYER, SELLER, LANDLORD, TENANT, DEVELOPER, INVESTOR, MANAGER, CONTRACTOR                                                                                                 |

--------------------------------------------------------------------------------------------------------------------

## Glossary

### Property Tags
- **HDB**: Public housing flats governed by the Housing & Development Board.
- **CONDO**: Private residential units with shared amenities.
- **RESIDENTIAL**: Properties intended for residential use.
- **LANDED**: Homes built on their own land, without shared walls (e.g., bungalows, terraces).
- **EC**: Executive Condominium – a subsidised option bridging public and private property.
- **COMMERCIAL**: Properties zoned for business operations.
- **RETAIL**: Space designated for shops and consumer-facing businesses.
- **INDUSTRIAL**: Sites for manufacturing, logistics, and heavy industry activities.
- **OFFICE**: Office spaces designed for corporate or business use.
- **WAREHOUSE**: Dedicated to storage and logistical operations.
- **SHOPHOUSE**: Multi-use buildings with commercial space on the ground floor, residential above.
- **TERRACE**: Row houses sharing side walls, commonly in clusters.
- **SEMIDET**: Semi-detached houses sharing one side wall.
- **BUNGALOW**: Single-story, standalone homes, often with private land.
- **DETACHED**: Fully standalone houses, no shared walls.
- **GCB**: Good Class Bungalows – high-end, exclusive bungalows with strict land requirements.
- **PENTHOUSE**: Premium top-floor units, typically in condos, with added privacy and amenities.
- **MIXED**: Properties combining multiple zoning uses, like residential and commercial.
- **SERVAPT**: Furnished serviced apartments, typically with extended-stay services.
- **DORM**: Dormitories, often used as shared housing for students or workers.

### Person Tags
- **BUYER**: Prospective property purchasers.
- **SELLER**: Property owners seeking to sell.
- **LANDLORD**: Property owners leasing to tenants.
- **TENANT**: Individuals or entities renting properties.
- **DEVELOPER**: Companies or individuals creating or renovating properties.
- **INVESTOR**: Individuals or groups acquiring property for financial gain.
- **MANAGER**: Those managing property operations, tenant relations, or maintenance.
- **CONTRACTOR**: Professionals providing construction, renovation, or repair services.
