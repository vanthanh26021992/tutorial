import axios from "axios";
import "primeicons/primeicons.css";
import { Button } from "primereact/button";
import { Column } from "primereact/column";
import { DataTable } from "primereact/datatable";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import React, { useEffect, useState } from "react";
import { CONFIG } from "../../ultils/constants";
import CreateInventory from "./CreateInventory";
import DeliveryBill from "./DeliveryBill";

function Inventory() {
  const [dataInventory, setDataInventory] = useState([]);
  const [visibleEdit, setVisibleEdit] = useState(false);
  const [visibleDelete, setVisibleDelete] = useState(false);
  const [id, setId] = useState();
  const [productCode, setProductCode] = useState("");
  const [productName, setProductName] = useState("");
  const [unit, setUnit] = useState("");
  const [quantity, setQuantity] = useState();
  const [priceBuy, setPriceBuy] = useState();
  const [priceTotal, setPriceTotal] = useState();

  useEffect(() => {
    getInventory();
  }, []);

  const getInventory = () => {
    axios
      .get(`${CONFIG.SERVER}/inventory/get-all`)
      .then(function (response) {
        setDataInventory(response.data);
      })
      .catch(function (error) {});
  };

  const bodyInventory = (todo) => (
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
    setQuantity(todo.quantity);
    setPriceBuy(todo.priceBuy);
    setPriceTotal(todo.priceTotal);
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
        `${CONFIG.SERVER}/inventory/update`,
        JSON.stringify({
          id: id,
          productCode: productCode,
          productName: productName,
          unit: unit,
        }),
        { headers }
      )
      .then((response) => {
        getInventory();
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
      .delete(`${CONFIG.SERVER}/inventory/delete-by-id/${id}`, headers)
      .then((response) => {
        setVisibleDelete(false);
        getInventory();
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="App">
      <div className="receipt">
        <CreateInventory getInventory={getInventory} />
        <DeliveryBill getInventory={getInventory} />
      </div>

      <div className="card">
        <DataTable value={dataInventory} tableStyle={{ minWidth: "50rem" }}>
          <Column field="productCode" header="ProductCode"></Column>
          <Column field="productName" header="ProductName"></Column>
          <Column field="unit" header="Unit"></Column>
          <Column field="quantity" header="Quantity"></Column>
          <Column field="priceBuy" header="PriceBuy"></Column>
          <Column field="priceTotal" header="PriceTotal"></Column>
          <Column field="date" header="Date"></Column>
          <Column header="Active" body={bodyInventory}></Column>
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
              <div className="in-block-inventory">
                <label className="labelInputInventory">ProductCode: </label>{" "}
                <br />
                <InputText
                  aria-describedby="productCode-help"
                  value={productCode}
                  onChange={(e) => setProductCode(e.target.value)}
                  disabled
                />
              </div>
              <div className="in-block-inventory">
                <label className="labelInputInventory">ProductName: </label>{" "}
                <br />
                <InputText
                  type="productName"
                  aria-describedby="productName-help"
                  value={productName}
                  onChange={(e) => setProductName(e.target.value)}
                />
                <small id="productName-help"></small>
              </div>

              <div className="in-block-inventory">
                <label className="labelInputInventory">Unit: </label> <br />
                <InputText
                  id="unit"
                  aria-describedby="unit-help"
                  value={unit}
                  onChange={(e) => setUnit(e.target.value)}
                />
                <small id="unit-help"></small>
              </div>
            </div>

            <div className="flex flex-column gap-2">
              <div className="in-block-inventory">
                <label className="labelInputInventory">Quantity: </label> <br />
                <InputText
                  aria-describedby="quantity-help"
                  value={quantity}
                  onChange={(e) => setQuantity(e.target.value)}
                />
              </div>
              <div className="in-block-inventory">
                <label className="labelInputInventory">PriceBuy: </label> <br />
                <InputText
                  type="priceBuy"
                  aria-describedby="priceBuy-help"
                  value={priceBuy}
                  onChange={(e) => setPriceBuy(e.target.value)}
                />
              </div>

              <div className="in-block-inventory">
                <label className="labelInputInventory">PriceTotal: </label>{" "}
                <br />
                <InputText
                  id="priceTotal"
                  aria-describedby="priceTotal-help"
                  value={priceTotal}
                  onChange={(e) => setPriceTotal(e.target.value)}
                />
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

export default Inventory;

// đánh chữ vào chọn code auto - hiện lỗi
