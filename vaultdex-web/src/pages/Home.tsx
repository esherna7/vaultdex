import Card from "../components/card/Card";
import CardGrid from "../components/grid/CardGrid";
import HeaderBar from "../components/header/HeaderBar";
import { useTcgDexSetById } from "../hooks/useTcgDex";

const Home = () => {
    const { data, isLoading, isError } = useTcgDexSetById("me03");

    if (isLoading) return <div>Loading...</div>;
    if (isError) return <div>Failed to load card data.</div>;

    return (
        <div>
            <HeaderBar />
            <h1 className="text-2xl font-bold">home page</h1>
            <CardGrid>
                {data.cards?.map((card) => (
                    <Card key={card.id} id={card.id} image={`${card.image}.png`} name={card.name} />
                ))}
            </CardGrid>
        </div>
    );
};

export default Home;