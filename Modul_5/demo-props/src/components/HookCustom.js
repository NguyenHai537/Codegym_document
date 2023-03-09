import useIncrement from "../hooks/useIncrement";

export default function HookCustom(){
    const[count,increase] = useIncrement();
    const[count2,increase2] = useIncrement();

    

    const handleCount1 = (e)=>{
        const addAmount = parseInt(e.target.value) ;
        increase(addAmount);
    }

    const handleCount2 = (e) =>{
        const addAmount = parseInt(e.target.value) ;
        increase2(addAmount);
    }

    return(
        <div>
            <div>
            <h3>Count: {count}</h3>
            <button onClick={handleCount1} value={1}>Add 1</button>
            </div>
            <br/>
            <div>
            <h3>Count:{count2}</h3>
            <button onClick={handleCount2} value={2}>Add 2</button>
            </div>
        </div>
    )
}