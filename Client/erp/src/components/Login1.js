import React from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import axios from "axios";

class Login1 extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: null,
      password: null,
      products: [],
    };

    this.getUsers();
  }
  //context
  getUsers() {
    console.log("Got here===== ");
    let component = this;
    console.log(this);
    axios
      .get(`http://localhost:8080/get-all`)
      .then(function (response) {
        console.log(this);
        component.state.products = response.data;
        component.forceUpdate();
        console.log(component.state.products);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  render() {
    //this.getUsers();
    console.log("render ======================= ");
    return (
      <div className="card">
        <DataTable
          value={this.state.products}
          tableStyle={{ minWidth: "50rem" }}
        >
          <Column field="id" header="ID"></Column>
          <Column field="username" header="Username"></Column>
          <Column field="password" header="Password"></Column>
          <Column field="fullname" header="Fullname"></Column>
          <Column field="age" header="Age"></Column>
          <Column field="phone" header="Phone"></Column>
          <Column field="address" header="Address"></Column>
          <Column field="gender" header="Gender"></Column>
        </DataTable>
      </div>
    );
  }
}
export default Login1;
