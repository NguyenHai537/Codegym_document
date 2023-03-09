import { useState } from "react";

const carList = ["Mecerdes","Audi","Toyota","Mazda","Honda"];
const colorList = ["Black","Red","White","Blue","Yellow"];

export default function Car (){
    const [selectedCar,setSelectedCar] = useState("Mecerdes");
    const [selectedColor,setSelectedColor] = useState("Black");

    const handleCar = (e) =>{
        const choice = e.target.value;
        setSelectedCar(carList[choice]);
    }

    const handleColor = (e) =>{
        const choice = e.target.value;
        setSelectedColor(colorList[choice]);
    }

    return(
        <div>
            <h1>Select Your Car</h1>
            <div>
                <p>Select a car</p>
                <select onChange={handleCar}>
                    <option value={"0"}>Mecerdes</option>
                    <option value={"1"}>Audi</option>
                    <option value={"2"}>Toyota</option>
                    <option value={"3"}>Mazda</option>
                    <option value={"4"}>Honda</option>
                </select>
            </div>
            <div>
            <p>Select a color</p>
                <select onChange={handleColor}>
                    <option value={"0"}>Black</option>
                    <option value={"1"}>Red</option>
                    <option value={"2"}>White</option>
                    <option value={"3"}>Blue</option>
                    <option value={"4"}>Yellow</option>
                </select>
            </div>
            <h3>You select a {selectedCar} - {selectedColor}</h3>
        </div>
    )
}