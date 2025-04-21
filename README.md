COMP242 Project I - Gaza Electricity Data Management System
Project Overview
This application implements an Electricity data management system for the Gaza Strip using combined sorted linked lists. The system provides a GUI interface built with JavaFX to manage electricity data records, generate statistics, and save updates.
Features
Data Management
* **Load Data**: Load electricity records from CSV files using a file chooser
* **Insert Records**: Add new electricity records with date selection via DatePicker
* **Update Records**: Modify existing electricity records
* **Delete Records**: Remove electricity records with confirmation dialog
* **Search Records**: Find specific records by date using a calendar interface
Statistics
The application provides comprehensive statistics with the following options:
* **Day Statistics**: View statistics for a specific day across all months and years
* **Month Statistics**: View statistics for a specific month across all days and years
* **Year Statistics**: View statistics for a specific year across all days and months
* **Total Statistics**: Calculate and display sum, average, minimum, and maximum values for all metrics:
   * Israeli Lines (MWs)
   * Gaza Power Plant (MWs)
   * Egyptian Lines (MWs)
   * Total Daily Supply (MWs)
   * Overall Demand (MWs)
   * Power Cuts (hours/day)
   * Temperature
Save Functionality
* Save updated data back to the original file
* Save data to a new CSV file via file chooser
Data Structure
The project implements a combined sorted linked list with three levels:
1. Year list - organized by year
2. Month list - organized by month within each year
3. Day list - organized by day within each month
4. ElectricityRecord - the data stored for each specific date
This structure allows for efficient insertion, deletion, and lookup of records by date.
Data Format
Each electricity record includes:
* Date (YYYY-MM-DD format)
* Israeli Lines (MWs)
* Gaza Power Plant (MWs)
* Egyptian Lines (MWs)
* Total Daily Supply (MWs)
* Overall Demand (MWs)
* Power Cuts (hours/day)
* Temperature
Implementation Details
* Built using JavaFX for the graphical user interface
* Pure code implementation (no Scene Builder used)
* Menu-based navigation with the following sections:
   * Management menu (Insert, Update, Delete, Search)
   * Statistics menu (Day, Month, Year, Total)
   * File menu (Open, Print)
   * Save menu (Save, Save new file)
* Uses DatePicker for date selection
* All data operations use the linked list data structure (no arrays or ArrayList)
How to Run
1. Compile the Java source files
2. Run the `HelloApplication` main class
3. Use the File menu to open the electricity data CSV file
4. Navigate through the interface menus to manage data and view statistics
Background
This project utilizes real-world data from the Gaza Strip, which has suffered from chronic electricity deficits for over a decade. The data source is the Gaza Electricity Distribution Company (GEDCO), which provides this information daily to the United Nations Office for the Coordination of Humanitarian Affairs (OCHA).
References
* Background information: https://www.ochaopt.org/page/gaza-strip-electricity-supply . read the file and update the readme
