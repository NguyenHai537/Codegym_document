import { useState } from "react";

export default function useIncrement(){
    const [count, setCount] = useState(0);

    const  increase = (addAmount) =>{
        setCount(count + addAmount);
    }

    return [count,increase];
}