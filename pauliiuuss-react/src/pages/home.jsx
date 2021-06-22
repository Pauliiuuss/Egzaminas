import React, { Component } from "react";
import NavBar from "../components/NavBar";
import KlientoForm from "../components/KlientoFormComponent"

export default class home extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <NavBar />
          <KlientoForm />
        </div>
      </div>
    );
  }
}
