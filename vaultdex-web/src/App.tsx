import { useState } from 'react';
import './App.css';
import useCards from './hooks/useCards';

function App() {
  const [count, setCount] = useState(0);
  const data = useCards();

  return (
    <>
      This is the current count: {count}
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <div>
        data from useCards: {JSON.stringify(data.data)}
      </div>
    </>
  )
}

export default App
