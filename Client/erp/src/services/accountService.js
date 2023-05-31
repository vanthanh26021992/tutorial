import axios from "axios";
import { CONFIG } from "../ultils/constants";
import { useState } from "react";

const AccountSevice = {
  async getAccounts() {
    console.log("Get account AccountSevice");
    await axios.get(`${CONFIG.SERVER}/get-all`).then((response) => {
      console.log("response.data", response.data);
      return response.data;
    });
  },
};

export default AccountSevice;
