/**
 * @jsx React.DOM
 */
var InvoiceInfo = React.createClass({

	getInitialState: function() {
		return { customer: null,
				 date: null,
				 invoiceNumber: null,
			   };
	},

	handleFieldChange: function(field, event) {
		var keyValuePair = {};
		keyValuePair[field] = event.target.value;
		this.setState(keyValuePair);
	},
	
	render: function() {
		return (
			<div className="row">
				<div className="col-md-5 form-group">
					<label htmlFor="customer-name header-style">Customer Name</label>
					<input type="text" className="form-control" id="customer-name" onChange={this.handleFieldChange.bind(this, "customer")}/>
				</div>
				<div className="col-md-3 form-group">
					<label htmlFor="date header-style">Date</label>
					<input type="text" className="form-control" id="date" onChange={this.handleFieldChange.bind(this, "date")}/>
				</div>
				<div className="col-md-4 form-group">
					<label htmlFor="invoice-number header-style">Invoice Number</label>
					
					<input type="text" className="form-control" id="invoice-number" onChange={this.handleFieldChange.bind(this, "invoiceNumber")}/>
				</div>
			</div>
		)
	}
});