/**
 * @jsx React.DOM
 */
var WelcomePage = React.createClass({

	handleStartButtonPress: function() {
		var form = React.createElement(InvoiceForm);
		ReactDOM.render(form, document.getElementById('main'));
	},

	render: function () {
		return (
			<div className="jumbotron text-center">
				<h1 className="col-md-12"><b>CREATE CUSTOMIZED INVOICE</b></h1>
				<p>Click on the button to generate an invoice form</p>
				<button type="button" className="btn btn-info btn-lg" onClick={this.handleStartButtonPress}>Invoice Form</button>
			</div>
		);
	}
});

var welcomePage = React.createElement(WelcomePage);
ReactDOM.render(welcomePage, document.getElementById('main'));