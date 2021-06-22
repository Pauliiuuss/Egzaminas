import React, { Component } from "react";
import KlientoForm from "../components/KlientoFormComponent";
import NavBar from "../components/NavBar";

export default class admin extends Component {
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
