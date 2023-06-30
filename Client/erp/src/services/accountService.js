import axios from "axios";
import { CONFIG } from "../ultils/constants";
import { useState } from "react";

const AccountSevice = {
  async getAccounts() {
    let data;
    await axios
      .get(`${CONFIG.SERVER}/account/get-all`)
      .then((res) => (data = res.data))
      .catch((err) => console.log(err));
    return data;
  },
};

export default AccountSevice;
