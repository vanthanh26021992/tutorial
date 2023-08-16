import axios from "axios";
import { AutoComplete } from "primereact/autocomplete";
import { Button } from "primereact/button";
import { Dialog } from "primereact/dialog";
import { InputNumber } from "primereact/inputnumber";
import { InputText } from "primereact/inputtext";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import React, { useState } from "react";
import InventoryService from "../../services/InventoryService";
import { CONFIG } from "../../ultils/constants";

function DeliveryBill({ getInventory, getAccounts }) {
  const [visibleDeliveryBill, setVisibleDeliveryBill] = useState(false);
  const [inventoryName, setInventoryName] = useState("");
  const [unit, setUnit] = useState("");
  const [quantity, setQuantity] = useState();
  const [priceBuy, setPriceBuy] = useState();
  const [priceTotal, setPriceTotal] = useState();
  const [products, setProducts] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState("");

  const onClickDiliveryBill = (todo) => {
    const headers = { "Content-Type": "application/json;charset=utf-8" };
    axios
      .post(
        `${CONFIG.SERVER}/inventory/update`,
        JSON.stringify({
          productId: selectedProduct.id,
          productsCode: selectedProduct.productCode,
          productsName: inventoryName,
          unit: unit,
          quantity: quantity,
          priceBuy: priceBuy,
          priceTotal: priceTotal,
        }),
        { headers }
      )
      .then((response) => {
        getInventory();
      })
      .catch((error) => console.log(error));
    setVisibleDeliveryBill(false);
  };

  const searchInventory = async (event) => {
    const products = await InventoryService.searchInventoryByName(event.query);
    setProducts(products);
  };

  const onSelecteProduct = (e) => {
    const product = e.value;
    setSelectedProduct(product);
    setInventoryName(product.productName);
    setUnit(product.unit);
  };

  const onChangePrice = (e) => {
    setPriceBuy(e.value);
  };

  const onChangeQuantity = (e) => {
    setQuantity(e.value);
    console.log(priceTotal);
  };

  return (
    <div className="App">
      <header>
        <Button
          label="Inventory Out"
          text
          onClick={() => setVisibleDeliveryBill(true)}
        />
        <div className=" flex justify-content-center">
          <Dialog
            header="Inventory Out"
            style={{ width: "50vw", textAlign: "center" }}
            visible={visibleDeliveryBill}
            onHide={() => setVisibleDeliveryBill(false)}
          >
            <div className="">
              <div className="">
                <div className="flex flex-column gap-2">
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">
                      InventoryCode:{" "}
                    </label>{" "}
                    <br />
                    <AutoComplete
                      field="productCode"
                      value={selectedProduct}
                      suggestions={products}
                      completeMethod={searchInventory}
                      onChange={(e) => onSelecteProduct(e)}
                    />
                  </div>
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">
                      InventoryName:{" "}
                    </label>{" "}
                    <br />
                    <InputText
                      id="inventoryName"
                      type="inventoryName"
                      required
                      value={inventoryName}
                      minLength={7}
                      aria-describedby="inventoryName-help"
                      onChange={(e) => setInventoryName(e.target.value)}
                    />
                  </div>

                  <div className="in-block-inventory">
                    <label className="labelInputinventory">Unit: </label> <br />
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
                    <label className="labelInputinventory">Quantity: </label>{" "}
                    <br />
                    <InputNumber
                      required
                      value={quantity}
                      aria-describedby="inventoryCode-help"
                      onValueChange={(e) => onChangeQuantity(e)}
                    />
                  </div>
                  <div className="in-block-inventory">
                    <label className="labelInputinventory">PriceBuy: </label>{" "}
                    <br />
                    <InputNumber
                      type="inventoryName"
                      value={priceBuy}
                      required
                      aria-describedby="inventoryName-help"
                      onValueChange={(e) => onChangePrice(e)}
                    />
                  </div>

                  <div className="in-block-inventory">
                    <label className="labelInputinventory">PriceTotal: </label>{" "}
                    <br />
                    <InputNumber
                      id="priceTotal"
                      value={priceBuy * quantity}
                      aria-describedby="priceTotal-help"
                      onChange={(e) => setPriceTotal(e.target.value)}
                    />
                  </div>
                </div>
              </div>

              <div className="center">
                <Button
                  label="Yes"
                  icon="pi pi-check"
                  type="submit"
                  onClick={onClickDiliveryBill}
                />
                <Button
                  label="No"
                  icon="pi pi-times"
                  onClick={() => {
                    setVisibleDeliveryBill(false);
                    setSelectedProduct("");
                    setInventoryName("");
                    setUnit("");
                  }}
                  className="p-button-text"
                />
              </div>
            </div>
          </Dialog>
        </div>
      </header>
    </div>
  );
}

export default DeliveryBill;
