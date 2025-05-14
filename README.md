# Cafe Ordering System

A console-based Java application that simulates a cafe ordering system. It allows customers to place orders for various beverages, checks store hours, handles closures, and processes user inputs.

## Features

* 📅 Checks the current date and day of the week; closes on Thursdays
* 🕗 Displays store hours (8:00 AM – 9:30 PM)
* ☕ Offers a menu of drink types: coffee, milkshake, tea
* 🍹 Customizable options: sizes (small, medium, large), foam types, milk types, flavors
* 📋 Processes orders interactively with multiple selections
* 🔄 Handles case-insensitive input for robust user experience
* 🎉 Includes special scenarios (e.g., weekend closures)

## Prerequisites

* Java Development Kit (JDK) 8 or higher
* A Java-compatible IDE or command-line tools

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/vamsikumarGedela/CafeOrderSystem.git
   cd cafe-ordering-system
   ```
2. Compile the source code:

   ```bash
   javac src/CafeOrderSystem/*.java
   ```
3. Run the application:

   ```bash
   java -cp src CafeOrderSystem.CafeOrderSystem
   ```

## Usage

1. Execute the application as shown above.
2. Follow on-screen prompts:

   * Choose whether to view full inventory or online menu.
   * Select drink type, size, foam, milk, and flavor options.
   * Input is case-insensitive; e.g., both `Coffee` and `coffee` are accepted.
3. Example session:

   ```text
   Date: 2025-05-13
   Welcome to the Vamsi Cafe!
   
   Select a drink type (coffee, milkshake, tea): Coffee
   Select size (small, medium, large): Medium
   Select foam type (light foam, heavy foam, no foam): No foam
   Select milk type (2%, whole, soy, oat, coconut): Oat
   Select flavor (vanilla, caramel, mocha, hazelnut): Mocha

   Order confirmed! Thank you for ordering.
   ```

## Project Structure

```plaintext
cafe-ordering-system/
├── src/
│   └── CafeOrderSystem/
│       ├── CafeOrderSystem.java    # Main application
│       ├── Menu.java               # Menu definitions and loading
│       └── OrderProcessor.java     # Order handling and input validation
├── README.md                      # Project README file
└── LICENSE                        # License information
```

## Testing

* **Thursday closure**: Run the app on a Thursday; expect a closed message.
* **Invalid input handling**: Enter unsupported options; app should reprompt.
* **Case-insensitivity**: Test uppercase vs. lowercase entries.
* **Weekend scenario**: Verify behavior for weekend dates (if configured).

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request

## License

Distributed under the MIT License. See `LICENSE` for details.

## Author

* **Vamsi Kumar** - Initial development
* [GitHub Profile](https://github.com/vamsikumarGedela)
