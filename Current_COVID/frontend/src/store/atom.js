import { atom } from "recoil";
import { recoilPersist } from "recoil-persist";

const { persistAtom } = recoilPersist();

export const loginState = atom({
  key: "loginState",
  default: false,
  effects_UNSTABLE: [persistAtom],
});

export const postFormState = atom({
  key: "postFormState",
  default: {
    title: "",
    contents: "",
    createDt: 0,
    postResourcesList: [],
    comments: [],
  },
});

export const uploadFormState = atom({
  key: "uploadFormState",
  default: {
    title: "",
    contents: "",
    createDt: "",
    postResourcesList: [],
  },
});

export const mainState = atom({
  key: "mainState",
  default: {
    user: {},
  },
  effects_UNSTABLE: [persistAtom],
});
