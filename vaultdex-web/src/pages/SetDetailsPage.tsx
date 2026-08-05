import React from "react";
import { useTcgDexSetById } from "../hooks/useTcgDex";
import Card from "../components/card/Card";
import CardGrid from "../components/grid/CardGrid";

interface ISetDetailsPageProps {
    setId: string;
}

const SetDetailsPage = ({ setId }: ISetDetailsPageProps) => {

    // const {data, isLoading, error} = useTcgDexSetById('me03');
    const { data, isLoading, error } = useTcgDexSetById(setId);

    const cards = data?.cards || [];
    console.log('data in set', data);


    return (
        <div>
            <h1>Set Details Page</h1>
            {isLoading && <p>Loading...</p>}
            <img src={`${data?.logo}.png`} alt="Set Logo" className="mx-auto my-4" />
            {error && <p>Error: {error.message}</p>}
            {cards.length > 0 ?
                <CardGrid>
                    {cards.map((card) => (
                        <Card key={card.id} id={card.id} image={card.image} name={card.name} />
                    ))}
                </CardGrid>
                : <p>No cards found for this set.</p>}
        </div>
    );
}

export default SetDetailsPage;