/**
 * @jsx React.DOM
 */
var InvoiceLine = React.createClass({
	getInitialState: function() {
		return { product: this.props.products[0],
				 quantity: 0,
				 price: 0,
				 total: 0 
			   };
	},
	
	handleLineFieldChange: function(field, event) {
		var keyValuePair = {};
		keyValuePair[field] = event.target.value;
		if (field == "quantity" || field == "price") {
			this.setState(keyValuePair, this.updateTotal);
		} else {
			this.setState(keyValuePair);
		}
	},
	
	updateTotal: function() {
		this.setState({total: (this.state.quantity * this.state.price)});
	},
	
	handleButtonPress: function(buttonType) {
		this.props.callback(buttonType, this.props.lineID);
	},
	
	render: function() {
		var lines = [];
		for (var i = 0; i < this.props.products.length; i++) {
			var productKey = this.props.lineID + "." + i;
			lines.push(<option key={productKey}>{this.props.products[i]}</option>);
		}
		var removeButton = <button className="btn-circle btn-danger glyphicon glyphicon-minus" onClick={this.handleButtonPress.bind(this, "remove")} />;
		if (this.props.numberOfLines <= 1) {
			removeButton = null;
		}
		return (
			<div className="row">
				<div className="col-md-4 form-group">
				  <label htmlFor="comp-select">Product</label>
				  <select className="form-control" onChange={this.handleLineFieldChange.bind(this, "product")}>
					{lines}
				  </select>
				</div>
				 <div className="col-md-2 form-group">
					<label htmlFor="quantity">Quantity</label>
					<input type="text" className="form-control" id="quantity" onChange={this.handleLineFieldChange.bind(this, "quantity")} />
				</div>
				<div className="col-md-2 form-group">
					<label htmlFor="price">Price</label>
					<input type="text" className="form-control" id="price" onChange={this.handleLineFieldChange.bind(this, "price")}/>
				</div>
				<div className="col-md-2 form-group">
					<label htmlFor="total">Total</label>
					<input type="text" className="form-control" id="total" value={this.state.total} />
				</div>
				<div className="col-md-2 text-center">
					<button className="btn-circle btn-primary glyphicon glyphicon-plus" onClick={this.handleButtonPress.bind(this, "add")} />
					{removeButton}	
				</div>
			</div>
		);
	}
});