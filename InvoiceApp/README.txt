AUTHOR:
Minh Hoang
Email: luuminh20@yahoo.com

LIBRARIES INCLUDED:
- Bootstrap: http://getbootstrap.com/
- Bootstrap's Glyphicons: http://glyphicons.com/
- React JS v0.14: https://facebook.github.io/react/
- jQuery: https://jquery.com/

DIFFERENT VERSIONS OF THE APP
- Version 1 (index_compact.html): The index_compact.html is the complete script (HTML and JS included in one file). This script runs with all big 3 browsers (Chrome, Firefox and IE) and it runs the latest React JS (0.14).
- Version 2 (index.html): The index.html and all the JSX files are the other version of the app. This version is more well-organized as components are broken down into JSX files and the index.html script only handles the initiation. However, this version uses JSXTransformer which is no longer supported by React JS since version 0.13.3. The reason I chose to use JSXTransformer was because I could not get Babel (the new JSX compiler suggested by React JS) to include all my external JS(X) files. Another drawback with this version is that, because external scripts are included locally, Chrome will refuse to load the page citing the "cross-origin requests are only supported for http" error.

RUNNING THE SCRIPTS:
Please refrain from changing the directory structure of the project as the scripts rely on relative paths for looking up to include external libraries/scripts.
- Version 1 (index_compact.html): You can simply load the HTML script up with any browsers. 
- Version 2 (index.html): You can either load the HTML script up in Firefox or host the whole project in a webserver where the external scripts can be served to the main page. If you choose to host the project on a webserver, you will also need to update the 'src' paths of the scripts included in the HTML page to the new paths specified by your webserver.

CODE-STRUCTURE EXPLANATION:
The entire application is broken down in 4 React components: WelcomePage, InvoiceForm, InvoiceInfo and InvoiceLine. WelcomePage loads up the main page and waits for the user to click the 'Invoice Form' to bring up the Invoice Form page. InvoiceForm takes care of loading up its sub-components InvoiceInfo and InvoiceLine. InvoiceInfo is the component for the first panel where users can type in customer's name, date and invoice number. The InvoiceForm stores all the InvoiceLine's in a list and adds/removes a line when a user clicks on either the '+' or the '-' buttons of that line. The InvoiceLine takes care of saving the data input by the user and calculates the total based on the quantity and price of the product selected by the user. The InvoiceForm also listens to the 'Save' and 'Cancel' buttons which are at the right bottom corner of the page. When the user clicks the 'Save' button, the InvoiceForm traverses through all its sub-components and converts their data into JSON format and presents the the whole-form JSON-formatted data to user in a dialog. Otherwise, if the user clicks the 'Cancel' button, a confirmation dialog is shown and if the user chooses to proceed with the cancelation, the InvoiceForm is cleared and the user is brought back to the Welcome page.
*Note: The current 'date' field does not include a date picker or any validation code so users can enter any invalid data and form will still save with no complaints. This is one improvement aspect which I never got around to include as I could not find a DatePicker snippet that I like.