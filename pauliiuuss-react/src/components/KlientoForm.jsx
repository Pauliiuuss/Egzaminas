import React, { Component } from "react";
import axios from "axios";

import KlientoFormComponent from "./KlientoFormComponent";

export default class KlientoFormContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      sveikinimoVieta: "",
      vardas: "",
      pavarde: "",
      gimimoData:null,
      telNumeris:"",
      tipas:"",
    };
  }

  handleSubmit = (e) => {
    e.preventDefault();
      axios.post(`localhost:8088/api/klientas/add`, {
        vardas: this.state.vardas || "",
        pavarde: this.state.pavarde || "",
        gimimoData: this.state.gimimoData || "",
        telNumeris: this.state.telNumeris || "",
        tipas: this.state.tipas || "",
      });

      this.setState({
        vardas: "",
        pavarde: "",
        gimimoData: "",
        telNumeris: "",
        tipas: "",
      });

  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <KlientoFormComponent
        handleSubmit={this.handleSubmit}
        handleChange={this.handleChange}
        {...this.state}
      />
    );
  }
}
