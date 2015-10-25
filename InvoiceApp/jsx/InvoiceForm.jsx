/**
 * @jsx React.DOM
 */
var InvoiceForm = React.createClass({
	getInitialState: function() {
		return { lineKeys: [1],
				 lineRefs: [],
				 infoRef: null,
				 formData: "",
			   };
	},
	
	getNextLineKey: function() {
		return (Math.max.apply(Math, this.state.lineKeys) + 1);
	},
	
	handleLineButtonPress: function(buttonType, lineKey) {
		if (buttonType == "add") {
			this.setState(function(state) {
				var cloneLineKeys = state.lineKeys.slice(0);
				cloneLineKeys.splice(cloneLineKeys.indexOf(lineKey) + 1, 0, this.getNextLineKey());
				return { lineKeys: cloneLineKeys };
			});
		} else if (buttonType == "remove") {
			this.setState(function(state) {
				var cloneLineKeys = state.lineKeys.slice(0);
				cloneLineKeys.splice(cloneLineKeys.indexOf(lineKey), 1);
				return { lineKeys: cloneLineKeys };
			});
			this.removeLineRef(lineKey);
		}
	},
	
	storeLineRef: function(lineRef) {
		var cloneLineRefs = this.state.lineRefs.slice(0);
		cloneLineRefs.push(lineRef);
		this.setState({ lineRefs: cloneLineRefs });
	},
	
	removeLineRef: function(lineKey) {
		var cloneLineRefs = this.state.lineRefs.slice(0);
		for (var i = 0; i < cloneLineRefs.length; i++) {
			if (cloneLineRefs[i] != null) {
				if (cloneLineRefs[i].props.lineID == lineKey) {
					cloneLineRefs.splice(i, 1);
					break;
				}
			}
		}
		this.setState({ lineRefs: cloneLineRefs });
	},
	
	submitInvoice: function() {
		var cloneLineRefs = this.state.lineRefs.slice(0);
		var formJSONData = "{";
		if (this.state.infoRef != null) {
			formJSONData += JSON.stringify(this.state.infoRef.state) + ",";
		}
		for (var i = 0; i < cloneLineRefs.length; i++) {
			if (cloneLineRefs[i] != null) {
				formJSONData += (JSON.stringify(cloneLineRefs[i].state) + ",");
			}
		}
		formJSONData += "}";
		console.log("JSON form: \n" + formJSONData);
		this.setState({formData: formJSONData});
	},
	
	exitInvoice: function() {
		var welcomePage = React.createElement(WelcomePage);
		ReactDOM.render(welcomePage, document.getElementById('main'));
	},
	
	generateLineTags: function(lineKey) {
		var instruments = ["Electric Guitar", "Acoustic Guitar", "Electric Bass", "Acoustic Bass", "Microphone", "Drum Kit"];
		return (<InvoiceLine key={lineKey} lineID={lineKey} callback={this.handleLineButtonPress} ref={this.storeLineRef} numberOfLines={this.state.lineKeys.length} products={instruments}/>);
	},
	
	storeInfoRef: function(objRef) {
		this.setState({ infoRef: objRef });
	},
	
	render: function () {
		return (
			<div className="container">
				<div className="row page-header">
					<h1 className="col-md-12 text-primary"><b>Invoice Form</b></h1>
				</div>
				<div className="panel-group">
					<div className="panel panel-primary">
						<div className="panel-heading"><h4>Invoice Information</h4></div>
						<div className="panel-body">
							<InvoiceInfo ref={this.storeInfoRef}/>
						</div>
						<div className="panel-footer"></div>
					</div>
					<div className="panel panel-primary">
						<div className="panel-heading"><h4>Product List</h4></div>
						<div className="panel-body">
							{ this.state.lineKeys.map( this.generateLineTags ) }
						</div>
						<div className="panel-footer"></div>
					</div>
				</div>
				<nav className="navbar navbar-default navbar-fixed-bottom">
					<div className="container-fluid">
						<div className="col-md-12 text-right">
							<button className="btn btn-success" onClick={this.submitInvoice} data-toggle="modal" data-target="#save-dialog-modal">Save</button>
							<button className="btn btn-warning" data-toggle="modal" data-target="#user-confirm-modal">Cancel</button>
						</div>
					</div>
				</nav>
				<div id="user-confirm-modal" className="modal fade" role="dialog">
					<div className="modal-dialog">
						<div className="modal-content">
							<div className="modal-header bg-primary">
								<button type="button" className="close" data-dismiss="modal">&times;</button>
								<h4 className="modal-title">Message</h4>
							</div>
							<div className="modal-body">
								<p>You will lose any unsaved data if you exit now. Are you sure you want to exit?</p>
							</div>
							<div className="modal-footer text-right">
								<button type="button" className="btn btn-success" onClick={this.exitInvoice} data-dismiss="modal">Yes</button>
								<button type="button" className="btn btn-warning" style={{marginBottom: 10}} data-dismiss="modal">No</button>
							</div>
						</div>
					</div>
				</div>
				<div id="save-dialog-modal" className="modal fade" role="dialog">
					<div className="modal-dialog">
						<div className="modal-content">
							<div className="modal-header bg-primary">
								<button type="button" className="close" data-dismiss="modal">&times;</button>
								<h4 className="modal-title">Message</h4>
							</div>
							<div className="modal-body">
								<p>This is the JSON-encoded data which will be sent to the backend:</p>
								<p>{this.state.formData}</p>
							</div>
							<div className="modal-footer text-right">
								<button type="button" className="btn btn-primary" style={{marginBottom: 10}} data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		);
	}
});