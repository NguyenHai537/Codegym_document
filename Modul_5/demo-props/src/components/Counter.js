import { useState } from "react";
function Counter(){
    let [count,setCount] = useState(0);
    
    const handleClick = () =>{
        const newValue = count +1;
        setCount(newValue);
    };

    return(
        <div>
            Gia Tri {count}
            <div>
                <button onClick={handleClick}>Tang</button>
            </div>
        </div>
    );

}
export default Counter;