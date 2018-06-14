func generateRandom() -> [Int] {
    //a working algortihm in swift.
    var firstDig : Int = Int(arc4random_uniform(10))
    var secondDig : Int = Int(arc4random_uniform(10))
    var thirdDig : Int = Int(arc4random_uniform(10))
    var fourthDig : Int = Int(arc4random_uniform(10))

    func checkRandomness() {
        if firstDig == secondDig || firstDig == thirdDig || firstDig == fourthDig {
            firstDig = Int(arc4random_uniform(10))
            checkRandomness()
        }
        if secondDig == thirdDig || secondDig == fourthDig {
            secondDig = Int(arc4random_uniform(10))
            checkRandomness()
        }
        if thirdDig == fourthDig {
            thirdDig = Int(arc4random_uniform(10))
            checkRandomness()
        }
        return
    }
    checkRandomness()
    return [firstDig,secondDig,thirdDig,fourthDig]

}
