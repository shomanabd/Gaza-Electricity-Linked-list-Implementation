# COMP242 Project I - Gaza Electricity Data Management System

This application implements an electricity data management system for the Gaza Strip using a hierarchical sorted linked list data structure. It features a graphical user interface (GUI) built with JavaFX for managing records, viewing statistics, and saving updates.

---

## 🔧 Features

### 📂 Data Management
- **Load Data**: Import electricity records from CSV files using a file chooser.
- **Insert Records**: Add new entries with date selection via a `DatePicker`.
- **Update Records**: Modify existing records.
- **Delete Records**: Remove entries with confirmation dialog.
- **Search Records**: Locate specific records by date using an intuitive calendar interface.

### 📊 Statistics
View detailed analytics based on time ranges:
- **Daily Statistics**: Compare data for a specific day across all months and years.
- **Monthly Statistics**: View stats for a specific month across all years.
- **Yearly Statistics**: Explore data trends for a specific year.
- **Total Statistics**: Displays sum, average, minimum, and maximum values for:
  - Israeli Lines (MWs)
  - Gaza Power Plant (MWs)
  - Egyptian Lines (MWs)
  - Total Daily Supply (MWs)
  - Overall Demand (MWs)
  - Power Cuts (hours/day)
  - Temperature

### 💾 Save Functionality
- Save updates to the original file.
- Save as a new CSV file using the file chooser.

---

## 🧱 Data Structure

Implements a three-tier **combined sorted linked list**:
1. **Year Node**: Top-level list sorted by year.
2. **Month Node**: Nested under each year, sorted by month.
3. **Day Node**: Nested under each month, sorted by day.
4. **ElectricityRecord**: Stores actual data for each day.

Efficient for insertion, deletion, and date-based lookup.

---

## 🧾 Data Format
Each record contains:
- Date (YYYY-MM-DD)
- Israeli Lines (MWs)
- Gaza Power Plant (MWs)
- Egyptian Lines (MWs)
- Total Daily Supply (MWs)
- Overall Demand (MWs)
- Power Cuts (hours/day)
- Temperature (°C)

---

## 🛠️ Implementation Details
- Built entirely in **JavaFX** (without Scene Builder)
- Menu-driven GUI with sections for:
  - Management (Insert, Update, Delete, Search)
  - Statistics (Day, Month, Year, Total)
  - File operations (Open, Print, Save)
- Date selection using JavaFX `DatePicker`
- All operations use a custom linked list (no arrays or ArrayLists used)

---

## ▶️ How to Run
1. Compile all `.java` files.
2. Run the `HelloApplication` main class.
3. Use the **File menu** to load electricity data from a CSV file.
4. Navigate menus to manage data and generate statistics.

---

## 🌍 Background
This project uses real-world data from the Gaza Strip, which has long faced electricity shortages. Data is sourced from the **Gaza Electricity Distribution Company (GEDCO)** and reported to the **United Nations Office for the Coordination of Humanitarian Affairs (OCHA)**.

### Reference
- [Gaza Strip Electricity Supply - OCHA](https://www.ochaopt.org/page/gaza-strip-electricity-supply)
