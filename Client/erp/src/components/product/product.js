import axios from "axios";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useEffect, useState } from "react";
import { CONFIG } from "../../ultils/constants";
import CreateProduct from "./CreateProduct";

function Product() {
  const [dataProduct, setDataProduct] = useState([]);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [id, setId] = useState();
  const [productCode, setProductCode] = useState("");
  const [productName, setProductName] = useState("");
  const [unit, setUnit] = useState("");

  useEffect(() => {
    getProduct();
  }, []);

  const getProduct = () => {
    axios
      .get(`${CONFIG.SERVER}/product/get-all`)
      .then(function (response) {
        setDataProduct(response.data);
      })
      .catch(function (error) {});
  };

  const bodyProduct = (todo) => (
    <>
      <Button
        icon="pi pi-user-edit"
        rounded
        text
        aria-label="Filter"
        onClick={() => onclickEdit(todo)}
      />
      <Button
        icon="pi pi-times"
        rounded
        text
        severity="danger"
        aria-label="Cancel"
        onClick={() => onClickShowPopupDelete(todo)}
      />
    </>
  );

  const onclickEdit = (todo) => {
    setId(todo.id);
    setProductCode(todo.productCode);
    setProductName(todo.productName);
    setUnit(todo.unit);
    setVisibleEdit(true);
  };

  const footerContentEdit = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickUpdate(todo)}
        autoFocus
      />
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleEdit(false)}
        className="p-button-text"
      />
    </div>
  );

  const onClickUpdate = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .put(
        `${CONFIG.SERVER}/product/update`,
        JSON.stringify({
          id: id,
          productCode: productCode,
          productName: productName,
          unit: unit,
        }),
        { headers }
      )
      .then((response) => {
        getProduct();
        setVisibleEdit(false);
      })
      .catch((error) => console.log(error));
  };

  const footerContentDelete = (todo) => (
    <div className="footerContentDialog">
      <Button
        label="Yes"
        icon="pi pi-check"
        onClick={() => onClickDelete(todo)}
        autoFocus
      />
      <Button
        label="No"
        icon="pi pi-times"
        onClick={() => setVisibleDelete(false)}
        className="p-button-text"
      />
    </div>
  );

  const onClickShowPopupDelete = (todo) => {
    setId(todo.id);
    setVisibleDelete(true);
  };

  const onClickDelete = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .delete(`${CONFIG.SERVER}/product/delete-by-id/${id}`, headers)
      .then((response) => {
        setVisibleDelete(false);
        getProduct();
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="App">
      <CreateProduct getProduct={getProduct} />
      <div className="card">
        <DataTable value={dataProduct} tableStyle={{ minWidth: "50rem" }}>
          <Column field="productCode" header="productCode"></Column>
          <Column field="productName" header="productName"></Column>
          <Column field="unit" header="unit"></Column>
          <Column header="Active" body={bodyProduct}></Column>
        </DataTable>
      </div>

      {/* Edit */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Header"
          style={{ width: "50vw", textAlign: "center" }}
          visible={visibleEdit}
          onHide={() => setVisibleEdit(false)}
          footer={footerContentEdit}
        >
          <div className="">
            <div className="flex flex-column gap-2">
              <div className="in-block-product">
                <label className="labelInputProduct">productCode: </label>{" "}
                <br />
                <InputText
                  aria-describedby="productCode-help"
                  value={productCode}
                  onChange={(e) => setProductCode(e.target.value)}
                  disabled
                />
              </div>
              <div className="in-block-product">
                <label className="labelInputProduct">productName: </label>{" "}
                <br />
                <InputText
                  type="productName"
                  aria-describedby="productName-help"
                  value={productName}
                  onChange={(e) => setProductName(e.target.value)}
                />
                <small id="productName-help"></small>
              </div>

              <div className="in-block-product">
                <label className="labelInputProduct">unit: </label> <br />
                <InputText
                  id="unit"
                  aria-describedby="unit-help"
                  value={unit}
                  onChange={(e) => setUnit(e.target.value)}
                />
                <small id="unit-help"></small>
              </div>
            </div>
          </div>
        </Dialog>
      </div>

      {/* Delete */}
      <div className="card flex justify-content-center">
        <Dialog
          header="Are you sure to delete?"
          visible={visibleDelete}
          style={{ width: "50vw", textAlign: "center" }}
          onHide={() => setVisibleDelete(false)}
          footer={footerContentDelete}
        ></Dialog>
      </div>
    </div>
  );
}

export default Product;
