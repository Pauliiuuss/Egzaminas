import React from "react";

const ProductAdministrationFormComponent = ({
  handleChange,
  handleSubmit,
  ...otherProps
}) => {
  const {
    vardas,
    pavarde,
    gimimoData,
    telNumeris,
    tipas,
  } = otherProps;
  return (
    <div>
      <form className="container my-5" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="vardas">Vardas</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="vardas"
            name="vardas"
            value={vardas}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="pavarde">Pavarde</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="pavarde"
            name="pavarde"
            value={pavarde}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="gimimo_data">Gimimo Data</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            type="date"
            id="gimimo_data"
            name="gimimo_data"
            value={gimimoData}
          ></textarea>
        </div>
        <div className="form-group">
          <label htmlFor="telNr">Telefono numeris</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="telNr"
            name="telNr"
            value={telNumeris}
          ></textarea>
        </div>
        <select class="form-select">
            <option selected>Open this select menu</option>
            <option value={tipas}>IPRASTAS</option>
            <option value={tipas}>LOJALUS</option>
          </select>
        <button type="submit" className="btn btn-primary" onSubmit={handleSubmit}>
          Save
        </button>
      </form>
    </div>
  );
};

export default ProductAdministrationFormComponent;
