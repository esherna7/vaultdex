import { useState } from 'react';
import './App.css';
import useCards from './hooks/useCards';
import { useTcgDexSetById, useTcgDexSets } from './hooks/useTcgDex';
import Home from './pages/Home';

function App() {
  // const data = useCards();
  // const data = useTcgDexSets();
  // const data = useTcgDexSetById('me03');
  // console.log('data', data.data);

  return (
    <>
      <div>
        {/* data from useCards: {JSON.stringify(data.data)} */}
        {/* <img src={`${data.data?.cards?.[0]?.image}.png`} alt="Set Logo" /> */}
        {/* <button className="bg-sky-500 hover:bg-sky-700">Test button</button> */}
        <Home />
      </div>
    </>
  )
}

export default App
